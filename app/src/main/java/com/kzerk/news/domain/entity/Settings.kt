package com.kzerk.news.domain.entity

data class Settings(
    val language: Language,
    val interval: Interval,
    val notificationEnabled: Boolean,
    val wifiOnly: Boolean
) {
    companion object {
        val DEFAULT_LANGUAGE = Language.ENGLISH
        val DEFAULT_INTERVAL = Interval.MINUTE_15
        const val DEFAULT_NOTIFICATION_ENABLED = false
        const val DEFAULT_WIFI_ONLY = false
    }
}

enum class Language {
    ENGLISH,
    RUSSIAN,
    GERMAN,
    FRENCH
}

enum class Interval(val minutes: Int) {
    MINUTE_15(15),
    MINUTE_30(30),
    HOUR_1(60),
    HOUR_2(120),
    HOUR_4(240),
    HOUR_8(480),
    HOUR_12(720),
    HOUR_24(1440)
}
