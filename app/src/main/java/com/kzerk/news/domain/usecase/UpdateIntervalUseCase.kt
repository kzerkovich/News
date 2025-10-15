package com.kzerk.news.domain.usecase

import com.kzerk.news.domain.entity.Interval
import com.kzerk.news.domain.repository.SettingsRepository
import jakarta.inject.Inject

class UpdateIntervalUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(interval: Interval) =
        settingsRepository.updateInterval(interval.minutes)

}