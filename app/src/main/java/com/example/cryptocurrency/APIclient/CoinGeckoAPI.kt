package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoAPI {
    @GET("coins/list")
    suspend fun coingeckoContents(): List<CoinList>

    @GET("coins/{id}")
    suspend fun coingeckoCoinById(@Query("id") id : String): CoinFullData
}