package com.example.cryptocurrency

import android.app.Application
import com.example.cryptocurrency.APIclient.CoinGeckoAPI
import com.example.cryptocurrency.Database.CryptoCurrencyRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CryptoCurrencyIntentApplication : Application() {

    lateinit var coinGeckoAPI: CoinGeckoAPI

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
        //CryptoCurrencyRepository.initialize(this)
    }

    private fun configureRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        coinGeckoAPI = retrofit.create(CoinGeckoAPI::class.java)
    }
}