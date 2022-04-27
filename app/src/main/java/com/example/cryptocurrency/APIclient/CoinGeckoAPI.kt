package com.example.cryptocurrency.APIclient

import retrofit2.Call
import retrofit2.http.GET

interface CoinGeckoAPI {
    @GET("coins/list")
    suspend fun coingeckoContents(): List<CoinList>
}