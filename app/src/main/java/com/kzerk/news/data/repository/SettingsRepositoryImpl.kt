package com.kzerk.news.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kzerk.news.data.mapper.toInterval
import com.kzerk.news.domain.entity.Language
import com.kzerk.news.domain.entity.Settings
import com.kzerk.news.domain.repository.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsRepositoryImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
) : SettingsRepository {

    private val languageKey = stringPreferencesKey("language")
    private val intervalKey = intPreferencesKey("interval")
    private val notificationEnabledKey = booleanPreferencesKey("notification_enabled")
    private val wifiOnlyKey = booleanPreferencesKey("wifi_only")

    override fun getSettings(): Flow<Settings> {
        return context.dataStore.data.map { preferences ->
            val languageAsString = preferences[languageKey] ?: Settings.DEFAULT_LANGUAGE.name
            val language = Language.valueOf(languageAsString)

            val interval = preferences[intervalKey]?.toInterval() ?: Settings.DEFAULT_INTERVAL


            Settings(
                language = language,
                interval = interval,
                notificationEnabled = preferences[notificationEnabledKey] ?: Settings.DEFAULT_NOTIFICATION_ENABLED,
                wifiOnly = preferences[wifiOnlyKey] ?: Settings.DEFAULT_WIFI_ONLY
            )
        }
    }

    override suspend fun updateLanguage(language: Language) {
        context.dataStore.edit { settings ->
            settings[languageKey] = language.name
        }
    }

    override suspend fun updateInterval(minutes: Int) {
        context.dataStore.edit { settings ->
            settings[intervalKey] = minutes
        }
    }

    override suspend fun updateNotificationEnabled(enabled: Boolean) {
        context.dataStore.edit { settings ->
            settings[notificationEnabledKey] = enabled
        }
    }

    override suspend fun updateWifiOnly(wifiOnly: Boolean) {
        context.dataStore.edit { settings ->
            settings[wifiOnlyKey] = wifiOnly
        }
    }
}