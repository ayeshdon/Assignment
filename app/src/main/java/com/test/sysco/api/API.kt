package com.test.sysco.api;

import com.test.sysco.model.PlanetModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * This interface use to define API end-points to retrofit
 */
interface API {

    @GET(Endpoints.allPlanet)
    fun getAllPlanetFromAPI(): Observable<PlanetModel>
}