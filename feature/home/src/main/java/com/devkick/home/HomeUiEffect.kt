package com.devkick.home

sealed class HomeUiEffect {
    data class ShowToast(val message: String) : HomeUiEffect()
}