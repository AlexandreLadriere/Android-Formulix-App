package com.alexandreladriere.f1companion.api

import com.alexandreladriere.f1companion.datamodel.SeasonRacesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ErgastApi {
    @GET("/api/f1/current.json")
    suspend fun getSeasonRaces() : Response<SeasonRacesResponse>
}