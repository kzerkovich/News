package com.kzerk.news.domain.repository

import com.kzerk.news.domain.entity.Language
import com.kzerk.news.domain.entity.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettings(): Flow<Settings>

    suspend fun updateLanguage(language: Language)

    suspend fun updateInterval(minutes: Int)

    suspend fun updateNotificationEnabled(enabled: Boolean)

    suspend fun updateWifiOnly(wifiOnly: Boolean)
}