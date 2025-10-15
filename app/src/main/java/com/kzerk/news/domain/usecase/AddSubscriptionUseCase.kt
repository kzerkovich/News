package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.NewsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class AddSubscriptionUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(topic: String) {
        newsRepository.addSubscription(topic)
        CoroutineScope(coroutineContext).launch {
            newsRepository.updateArticlesForTopic(topic)
        }
    }
}