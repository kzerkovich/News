package com.kzerk.news.data.mapper

import com.kzerk.news.domain.entity.RefreshConfig
import com.kzerk.news.domain.entity.Settings

fun Settings.toRefreshConfig(): RefreshConfig {
    return RefreshConfig(language, interval, wifiOnly)
}