package com.kzerk.news.presentation.startup

import com.kzerk.news.domain.usecase.StartRefreshDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppStartupManager @Inject constructor(
    private val startRefreshDataUseCase: StartRefreshDataUseCase
) {
    private val scope = CoroutineScope(Dispatchers.IO)

    fun startRefreshData() {
        scope.launch { startRefreshDataUseCase() }
    }
}