package com.example.reposearch.retrofit

import com.example.reposearch.model.FullResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("repositories")
    fun getServices(@Query("q")  query: String) : Call<FullResponse>

}