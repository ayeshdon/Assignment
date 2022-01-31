package com.test.assignment.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.assignment.BuildConfig
import com.test.assignment.api.API
import com.test.assignment.utils.Utils
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetModule {

    @Provides
    fun getHeaders(): HashMap<String, String> {
        val params = HashMap<String, String>()
        params["Content-Type"] = "application/json"
        params["Authorization"] = "563492ad6f91700001000001941d54625d7a43c6a8565b33e1384333"
        return params
    }


    @Provides
    protected fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }


    @Provides
    fun provideRetrofit(gson: Gson,okHttpClient:OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BuildConfig.API_URL).build()
    }


    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideNetworkService(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Provides
    fun getTimeOut(): Int {
        return 30
    }


    @Provides
    protected fun provideOkHttpClientDefault(interceptor: HttpLoggingInterceptor, headers: HashMap<String, String>, timeout: Int): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.addInterceptor(interceptor)
        okBuilder.addInterceptor { chain ->
            val request = chain.request()
            val builder = request.newBuilder()

            if (headers != null && headers.size > 0) {
                for ((key, value) in headers) {
                    builder.addHeader(key, value)
                    Utils.log(key, value)
                }
            }
            chain.proceed(builder.build())
        }

        okBuilder.connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.readTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.writeTimeout(timeout.toLong(), TimeUnit.SECONDS)

        return okBuilder.build()

    }

}