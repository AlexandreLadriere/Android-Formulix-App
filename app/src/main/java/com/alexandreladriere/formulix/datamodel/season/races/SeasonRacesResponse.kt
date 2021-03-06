package com.alexandreladriere.formulix.datamodel.season.races

import com.google.gson.annotations.SerializedName

data class SeasonRacesResponse(
    @SerializedName("MRData")
    val data: SeasonRacesData? = null
)
