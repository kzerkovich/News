package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.NewsRepository
import com.kzerk.news.domain.repository.SettingsRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.first

class UpdateSubscribedArticlesUseCase @Inject constructor(
    private val newsRepository: NewsRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): List<String> {
        val settings = settingsRepository.getSettings().first()
       return newsRepository.updateArticlesForAllSubscriptions(settings.language)
    }
}