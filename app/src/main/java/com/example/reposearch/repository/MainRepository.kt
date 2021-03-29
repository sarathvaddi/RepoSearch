package com.example.reposearch.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.reposearch.model.FullResponse
import com.example.reposearch.model.Repos
import com.example.reposearch.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainRepository {

    val reposSetterGetter = MutableLiveData<List<Repos>>()

    fun getServicesApiCall(query : String): MutableLiveData<List<Repos>> {

        val call = RetrofitClient.apiInterface.getServices(query)

        call.enqueue(object: Callback<FullResponse> {
            override fun onFailure(call: Call<FullResponse>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<FullResponse>,
                response: Response<FullResponse>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()?.Repos

                reposSetterGetter.value = data
            }
        })

        return reposSetterGetter
    }
}