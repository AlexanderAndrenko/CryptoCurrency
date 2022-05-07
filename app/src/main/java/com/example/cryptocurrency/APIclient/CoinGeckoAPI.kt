package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.example.cryptocurrency.APIclient.model.coins.CoinsMarketData
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

    @GET("coins/markets")
    suspend fun coingeckoCoinMarket(
        @Query("vs_currency") currency : String = "usd",
        @Query("ids") ids : String? = null,
        @Query("category") category : String? = null,
        @Query("order") order : String = "market_cap_desc",
        @Query("per_page") perPage : Int = 250,
        @Query("page") page : Int = 1,
        @Query("sparkline") sparkline: Boolean = false,
        @Query("price_change_percentage") pricaChangePerc : String = "1h,24h,7d,14d,30d,200d"
    ) : List<CoinsMarketData>
}