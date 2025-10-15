package com.kzerk.news.domain.repository

import com.kzerk.news.domain.entity.Article
import com.kzerk.news.domain.entity.Language
import com.kzerk.news.domain.entity.RefreshConfig
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getAllSubscriptions(): Flow<List<String>>

    fun startBackgroundRefresh(refreshConfig: RefreshConfig)
    suspend fun addSubscription(topic: String)

    suspend fun updateArticlesForTopic(topic: String,language: Language): Boolean

    suspend fun removeSubscription(topic: String)

    suspend fun updateArticlesForAllSubscriptions(language: Language): List<String>

    fun getArticlesByTopics(topics: List<String>): Flow<List<Article>>

    suspend fun clearAllArticles(topics: List<String>)
}