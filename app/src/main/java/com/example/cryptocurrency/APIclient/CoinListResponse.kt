package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.google.gson.annotations.SerializedName

class CoinListResponse {
    @SerializedName("CoinList")
    lateinit var coinList: List<CoinList>
}