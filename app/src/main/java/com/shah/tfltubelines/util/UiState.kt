package com.shah.tfltubelines.util

import com.shah.tfltubelines.model.TubeLineStatus

sealed class UiState {
    object Loading: UiState()
    data class Success(val tubeLineStatusResponse: TubeLineStatus): UiState()
    data class Error(val error: Throwable): UiState()
}
