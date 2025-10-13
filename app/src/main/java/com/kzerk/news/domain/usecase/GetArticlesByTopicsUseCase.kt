package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.entity.Article
import com.kzerk.news.domain.repository.NewsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetArticlesByTopicsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(topics: List<String>): Flow<List<Article>> {
        return newsRepository.getArticlesByTopics(topics)
    }
}