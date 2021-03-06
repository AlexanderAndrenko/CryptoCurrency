package com.example.cryptocurrency.APIclient

import android.util.Log
import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.example.cryptocurrency.APIclient.model.coins.CoinsMarketData
import com.example.cryptocurrency.BuildConfig.DEBUG
import com.example.cryptocurrency.LoadParameters
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.ViewModel.CoinViewModel
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

private const val API_HOST = "api.coingecko.com"
private const val API_BASE_PATH = "/api/v3"


class CoinGeckoClientAPI {

    suspend fun getCoinList(coinViewModel: CoinViewModel) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val coinGeckoAPI = retrofit.create(CoinGeckoAPI::class.java)
        val result : List<CoinsMarketData> = coinGeckoAPI.coingeckoCoinMarket()

        for (item in result) {
            var coin: Coin =
                Coin(
                    item.id,
                    item.name,
                    item.maxPrice,
                    item.maxPriceDate,
                    item.marketCapRank,
                    item.currentPrice,
                    item.priceCP1H,
                    item.priceCP24H,
                    item.priceCP7D,
                    item.priceCP14D,
                    item.priceCP30D,
                    item.priceCP200D
                )
            GlobalScope.launch {
                Log.d("Debug API", "Delete coin: " + coin.id + "; Name: " + coin.name)
                coinViewModel.deleteCoin(coin)
                delay(500)
                Log.d("Debug API", "insert coin: " + coin.id + "; Name: " + coin.name)
                coinViewModel.addCoin(coin)
            }
        }

        LoadParameters.LoadIsOver()
    }


    /*suspend fun GetCoinById(id : String, coinViewModel: CoinViewModel){

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val coinGeckoAPI = retrofit.create(CoinGeckoAPI::class.java)
        val currency : String = "usd"
        val coinFD: CoinFullData = coinGeckoAPI.coingeckoCoinById(id)
        var desc: String
        if (coinFD.description.get("en") == null) {
            desc = "No description"
        } else {
            desc = coinFD.description.get("en").toString()
        }

        var coin: Coin =
            Coin(
                id,
                coinFD.id,
                desc,
                coinFD.coingeckoRank.toInt(),
                coinFD.marketData?.currentPrice?.get(currency),
                coinFD.marketData?.priceChangePercentage1hInCurrency?.get(currency),
                coinFD.marketData?.priceChangePercentage24hInCurrency?.get(currency),
                coinFD.marketData?.priceChangePercentage7dInCurrency?.get(currency),
                coinFD.marketData?.priceChangePercentage14dInCurrency?.get(currency),
                coinFD.marketData?.priceChangePercentage30dInCurrency?.get(currency),
                coinFD.marketData?.priceChangePercentage60dInCurrency?.get(currency)
            )
        Log.d("Debug API", "Delete coin: " + coin.id + "; Name: " + coin.name)
        coinViewModel.deleteCoin(coin)
        Log.d("Debug API", "insert coin: " + coin.id + "; Name: " + coin.name)
        coinViewModel.addCoin(coin)
    }*/
}
