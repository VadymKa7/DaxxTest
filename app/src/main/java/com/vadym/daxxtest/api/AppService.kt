package com.vadym.daxxtest.api

import com.vadym.daxxtest.model.ComplicatedObject
import retrofit2.http.GET
import retrofit2.http.Query


interface AppService {
    companion object {
        const val ENDPOINT = "https://api.dailycaller.com/section/"
    }

    @GET("US?feed=fullsection&key=90ac1808fa3e0d0679464da550202a0a&json=yes")
    suspend fun   getNewsList(@Query("paged") page: Int? = null,
                          @Query("max_posts") limit: Int? = null) : ComplicatedObject

}