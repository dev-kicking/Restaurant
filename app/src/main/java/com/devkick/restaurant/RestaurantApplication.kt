package com.devkick.restaurant

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RestaurantApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        settingTimber()
    }

    private fun settingTimber() {
        Timber.plant(Timber.DebugTree())
    }
}