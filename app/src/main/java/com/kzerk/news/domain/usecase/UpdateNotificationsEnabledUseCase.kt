package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateNotificationsEnabledUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(enabled: Boolean) =
        settingsRepository.updateNotificationEnabled(enabled)
}