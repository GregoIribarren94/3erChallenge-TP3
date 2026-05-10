package com.example.a3er_challenge

import android.app.Application
import com.example.a3er_challenge.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Config.apiKey  = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.quotes_api_base_url)
    }
}
