package com.example.reposearch.model

import com.google.gson.annotations.SerializedName

data class Repos (
    @SerializedName("full_name")
    val full_name: String? = null,

    @SerializedName("html_url")
    val html_url: String? = null

)