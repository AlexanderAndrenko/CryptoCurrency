package com.example.cryptocurrency.APIclient.model.coins

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class CoinsMarketData(
    val id : String,
    val name : String,
    @SerializedName("market_cap_rank")
    val marketCapRank : Int,
    @SerializedName("ath")
    val maxPrice : Double,
    @SerializedName("ath_date")
    val maxPriceDate : String,
    @SerializedName("current_price")
    val currentPrice : Double?,
    @SerializedName("price_change_percentage_1h_in_currency")
    val priceCP1H: Double?,
    @SerializedName("price_change_percentage_24h_in_currency")
    val priceCP24H: Double?,
    @SerializedName( "price_change_percentage_7d_in_currency")
    val priceCP7D: Double?,
    @SerializedName("price_change_percentage_14d_in_currency")
    val priceCP14D: Double?,
    @SerializedName("price_change_percentage_30d_in_currency")
    val priceCP30D: Double?,
    @SerializedName( "price_change_percentage_200d_in_currency")
    val priceCP200D: Double?
)