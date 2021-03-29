package com.example.reposearch.model

import com.google.gson.annotations.SerializedName

data class FullResponse(
    @SerializedName("total_count")
    val count: Int? = null,

    @SerializedName("items")
    val Repos : List<Repos>)

