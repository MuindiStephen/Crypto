package com.steve_md.crypto_app

import android.app.Application
import timber.log.Timber


class CryptoApp : Application() {
    override fun onCreate () {
        super.onCreate()
        // Timber for Logging
        Timber.plant(Timber.DebugTree())
    }

}