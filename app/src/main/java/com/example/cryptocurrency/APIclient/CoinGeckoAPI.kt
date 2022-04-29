package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinList
import retrofit2.http.GET

interface CoinGeckoAPI {
    @GET("coins/list")
    suspend fun coingeckoContents(): List<CoinList>
}