package com.test.assignment.module
import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application) {

     var applicationInst: Application = application


    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInst
    }
}