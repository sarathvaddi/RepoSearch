package com.example.reposearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposearch.model.repos
import com.example.reposearch.repository.MainRepository

class RepoViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<List<repos>>? = null

    fun getUser(query : String) : LiveData<List<repos>>? {
        servicesLiveData?.postValue( MainRepository.getServicesApiCall(query).value)
        return servicesLiveData
    }

}