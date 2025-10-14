package com.kzerk.news.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/everything?apiKey=fadc77920bb04059a994d810a1755cf8")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}