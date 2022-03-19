package com.example.cryptocurrency.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Coins(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "Name") var name: String,
    @ColumnInfo(name = "Discription") var description: String,
    @ColumnInfo(name = "GenesisDate") var genesisDate: Date,
    @ColumnInfo(name = "CoingeckoRank") var coingeckoRank: Int,
    @ColumnInfo(name = "CurrentPriceUSD") var currentPrice: Double,
    @ColumnInfo(name = "PriceChangePerc1Hour") var priceCP1H: Double,
    @ColumnInfo(name = "PriceChangePerc24Hour") var priceCP24H: Double,
    @ColumnInfo(name = "PriceChangePerc7Days") var priceCP7D: Double,
    @ColumnInfo(name = "PriceChangePerc14Days") var priceCP14D: Double,
    @ColumnInfo(name = "PriceChangePerc30Days") var priceCP30D: Double,
    @ColumnInfo(name = "PriceChangePerc60Days") var priceCP60D: Double
){
}