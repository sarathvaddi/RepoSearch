package com.example.reposearch.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.reposearch.model.repos
import com.example.reposearch.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainRepository {

    val reposSetterGetter = MutableLiveData<List<repos>>()

    fun getServicesApiCall(query : String): MutableLiveData<List<repos>> {

        val call = RetrofitClient.apiInterface.getServices(query)

        call.enqueue(object: Callback<List<repos>> {
            override fun onFailure(call: Call<List<repos>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<repos>>,
                response: Response<List<repos>>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                reposSetterGetter.value = data
            }
        })

        return reposSetterGetter
    }
}