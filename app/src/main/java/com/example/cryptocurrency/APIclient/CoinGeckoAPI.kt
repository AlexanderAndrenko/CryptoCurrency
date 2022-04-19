package com.example.cryptocurrency.APIclient

import retrofit2.Call
import retrofit2.http.GET

interface CoinGeckoAPI {
    @GET("/")
    fun coingeckoContents(): Call<CoinGeckoResponse>
}