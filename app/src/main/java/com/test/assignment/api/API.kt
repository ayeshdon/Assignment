package com.test.assignment.api;

import com.test.assignment.model.ImageDataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This interface use to define API end-points to retrofit
 */
interface API {

    @GET(Endpoints.search)
    fun getImageDataFromAPI(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Observable<ImageDataModel>
}