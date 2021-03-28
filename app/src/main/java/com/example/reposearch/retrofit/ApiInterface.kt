package com.example.reposearch.retrofit

import com.example.reposearch.model.repos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("repositories")
    fun getServices(@Query("q")  query: String) : Call<List<repos>>

}