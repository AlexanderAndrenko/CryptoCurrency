package com.example.cryptocurrency

import android.app.Application
import com.example.cryptocurrency.Database.CryptoCurrencyRepository

class CryptoCurrencyIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //CryptoCurrencyRepository.initialize(this)
    }
}