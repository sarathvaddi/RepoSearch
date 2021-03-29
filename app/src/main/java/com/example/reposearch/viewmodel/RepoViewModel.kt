package com.example.reposearch.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.reposearch.model.Repos
import com.example.reposearch.repository.MainRepository

class RepoViewModel(applicaton : Application) : AndroidViewModel(applicaton) {


    fun getUser(query : String) : LiveData<List<Repos>>? {
        return MainRepository.getServicesApiCall(query)
    }

}