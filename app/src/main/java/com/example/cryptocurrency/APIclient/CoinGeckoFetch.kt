package com.example.cryptocurrency.APIclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Retrofit

class CoinGeckoFetch {
    private val coingeckoAPI : CoinGeckoAPI

    init {
        val retrofit : Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.coingecko.com/")
                .build()
        coingeckoAPI = retrofit.create(CoinGeckoAPI::class.java)
    }

/*    fun fetchContents(): LiveData<CoinGeckoResponse> {
        val responseLiveData : MutableLiveData<CoinGeckoResponse> = MutableLiveData()
        val coingeckoRequest : Call<CoinGeckoResponse> = coingeckoAPI.fetchContents()
    }*/
}

/*private const val API_HOST = "api.coingecko.com"
private const val API_BASE_PATH = "/api/v3"*/
