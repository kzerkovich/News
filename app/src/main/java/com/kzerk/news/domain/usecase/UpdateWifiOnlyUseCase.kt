package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateWifiOnlyUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(wifiOnly: Boolean) =
        settingsRepository.updateWifiOnly(wifiOnly)
}