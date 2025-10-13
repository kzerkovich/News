package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.NewsRepository
import jakarta.inject.Inject

class ClearAllArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(topics: List<String>) {
        newsRepository.clearAllArticles(topics)
    }
}