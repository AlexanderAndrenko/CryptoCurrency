package com.example.cryptocurrency.APIclient.model.coins

import androidx.room.Entity

@Entity
data class CoinList(
    val id: String,
    val symbol: String,
    val name: String
    /*val platforms: Map<String, String> = emptyMap(),*/
)