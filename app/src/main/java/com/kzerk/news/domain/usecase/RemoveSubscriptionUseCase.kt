package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.NewsRepository
import jakarta.inject.Inject

class RemoveSubscriptionUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(topic: String) {
        newsRepository.removeSubscription(topic)
    }
}