package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.NewsRepository
import jakarta.inject.Inject

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() {
        newsRepository.updateArticlesForAllSubscriptions()
    }
}