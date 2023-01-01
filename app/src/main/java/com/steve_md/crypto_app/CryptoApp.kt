package com.steve_md.crypto_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CryptoApp : Application() {
    override fun onCreate () {
        super.onCreate()
        // Timber for Logging
        Timber.plant(Timber.DebugTree())
    }

}