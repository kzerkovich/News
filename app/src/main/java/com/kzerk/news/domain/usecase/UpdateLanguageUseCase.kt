package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.entity.Language
import com.kzerk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateLanguageUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(language: Language) = settingsRepository.updateLanguage(language)
}