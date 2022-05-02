package com.example.cryptocurrency.APIclient

import android.util.Log
import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.example.cryptocurrency.BuildConfig.DEBUG
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.ViewModel.CoinViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
        val result : List<CoinList> = coinGeckoAPI.coingeckoContents()

        val currency : String = "usd"
        var counter : Int = 1

        for (item in result) {
            delay(2000L)
            val coinFD: CoinFullData = coinGeckoAPI.coingeckoCoinById(item.id)
            var desc: String
            if (coinFD.description.get("en") == null) {
                desc = "No description"
            } else {
                desc = coinFD.description.get("en").toString()
            }

            var coin: Coin =
                Coin(
                    item.id,
                    item.name,
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
        }
    }
}
