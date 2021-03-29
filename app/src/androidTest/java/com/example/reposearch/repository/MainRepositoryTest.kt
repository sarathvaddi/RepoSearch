package com.example.reposearch.repository

import androidx.lifecycle.MutableLiveData
import com.example.reposearch.model.Repos
import io.mockk.*
import junit.framework.Assert.assertNotNull
import org.junit.Test


class MainRepositoryTest {


    @Test
    fun testRepo() {
        val Repos: MutableLiveData<List<Repos>> = mockk()
        val repo: MainRepository = mockk()
        every { repo.getServicesApiCall(any()) } returns Repos
        assertNotNull(repo.reposSetterGetter)

    }


}