package com.example.cryptocurrency.APIclient

import androidx.room.Entity

@Entity
data class CoinList(
    val id: String,
    val symbol: String,
    val name: String,
    val platforms: Map<String, String> = emptyMap(),
)