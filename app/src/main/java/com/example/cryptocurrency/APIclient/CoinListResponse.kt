package com.example.cryptocurrency.APIclient

import com.google.gson.annotations.SerializedName

class CoinListResponse {
    @SerializedName("CoinList")
    lateinit var coinList: List<CoinList>
}