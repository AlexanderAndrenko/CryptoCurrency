package com.example.cryptocurrency.DataModel

import androidx.room.Entity

//import kotlinx.serialization.Serializable

//@Serializable
@Entity
data class CoinList(
    val id: String,
    val symbol: String,
    val name: String,
    val platforms: Map<String, String> = emptyMap(),
)