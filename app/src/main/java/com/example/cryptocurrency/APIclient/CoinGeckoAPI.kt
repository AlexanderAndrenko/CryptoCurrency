package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoAPI {
    @GET("coins/list")
    suspend fun coingeckoContents(): List<CoinList>

    @GET("coins/{id}")
    suspend fun coingeckoCoinById(
        @Path("id") id : String,
        @Query("localization") localization : Boolean = false,
        @Query("tickers") tickers : Boolean = false,
        @Query("market_data") marketdata : Boolean = true,
        @Query("community_data") communitydata : Boolean = false,
        @Query("developer_data") developerdata : Boolean = false,
        @Query("sparkline") sparkline : Boolean = false
    ): CoinFullData
}