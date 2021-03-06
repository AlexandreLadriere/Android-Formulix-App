package com.alexandreladriere.formulix.datamodel.season.standings.constructors

import com.google.gson.annotations.SerializedName

data class SeasonConstructorStandingsResponse(
    @SerializedName("MRData")
    val data: ConstructorStandingsData? = null
)
