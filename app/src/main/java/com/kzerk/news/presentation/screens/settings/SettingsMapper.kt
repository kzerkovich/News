package com.kzerk.news.presentation.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kzerk.news.R
import com.kzerk.news.domain.entity.Interval
import com.kzerk.news.domain.entity.Language


@Composable
fun Language.toReadableFormat(): String {
    return when (this) {
        Language.ENGLISH -> stringResource(R.string.english)
        Language.RUSSIAN -> stringResource(R.string.russian)
        Language.GERMAN -> stringResource(R.string.deutsch)
        Language.FRENCH -> stringResource(R.string.french)
    }
}

@Composable
fun Interval.toReadableFormat(): String {
    return when (this) {
        Interval.MINUTE_15 -> "15 minutes"
        Interval.MINUTE_30 -> "30 minutes"
        Interval.HOUR_1 -> "1 hour"
        Interval.HOUR_2 -> "2 hours"
        Interval.HOUR_4 -> "4 hours"
        Interval.HOUR_8 -> "8 hours"
        Interval.HOUR_12 -> "12 hours"
        Interval.HOUR_24 -> "24 hours"
    }
}