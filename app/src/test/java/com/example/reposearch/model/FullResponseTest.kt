package com.example.reposearch.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class FullResponseTest {

    @Test
    fun testFullResponseModel() {
        val Repos: List<Repos> = ArrayList()
        val repo = Repos("square", "square.com")
        val fullResponse = FullResponse(1, Repos)
        assertEquals(fullResponse.count, 1)
    }
}