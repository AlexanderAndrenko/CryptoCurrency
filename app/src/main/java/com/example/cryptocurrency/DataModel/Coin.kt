package com.example.cryptocurrency.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Coins")
data class Coin(
    @PrimaryKey var id: String,
    //@ColumnInfo(name = "Name") var name: String,
    @ColumnInfo(name = "Description") var description: String,
    @ColumnInfo(name = "GenesisDate") var genesisDate: Date,
    @ColumnInfo(name = "CoingeckoRank") var coingeckoRank: Int,
    @ColumnInfo(name = "CurrentPriceUSD") var currentPrice: Double,
    @ColumnInfo(name = "PriceChangePer1Hour") var priceCP1H: Double,
    @ColumnInfo(name = "PriceChangePer24Hour") var priceCP24H: Double,
    @ColumnInfo(name = "PriceChangePer7Days") var priceCP7D: Double,
    @ColumnInfo(name = "PriceChangePer14Days") var priceCP14D: Double,
    @ColumnInfo(name = "PriceChangePer30Days") var priceCP30D: Double,
    @ColumnInfo(name = "PriceChangePer60Days") var priceCP60D: Double
){
}