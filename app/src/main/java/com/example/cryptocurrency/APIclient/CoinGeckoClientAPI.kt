package com.example.cryptocurrency.APIclient

import com.example.cryptocurrency.APIclient.model.coins.CoinFullData
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.ViewModel.CoinViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_HOST = "api.coingecko.com"
private const val API_BASE_PATH = "/api/v3"


class CoinGeckoClientAPI {

    fun getCoinList(coinViewModel: CoinViewModel) {
        runBlocking {
            launch {
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
                var counter : Int = 1

                for (item in result){
                    launch {
                        delay(1250)
                        var coinFD : CoinFullData = coinGeckoAPI.coingeckoCoinById(item.id)
                        var currency : String = "usd"
                        var coin : Coin =
                            Coin(
                                item.id,
                                item.name,
                                coinFD.coingeckoRank.toInt(),
                                coinFD.marketData?.currentPrice?.get(currency),
                                coinFD.marketData?.priceChangePercentage1hInCurrency?.get(currency),
                                coinFD.marketData?.priceChangePercentage24hInCurrency?.get(currency),
                                coinFD.marketData?.priceChangePercentage7dInCurrency?.get(currency),
                                coinFD.marketData?.priceChangePercentage14dInCurrency?.get(currency),
                                coinFD.marketData?.priceChangePercentage30dInCurrency?.get(currency),
                                coinFD.marketData?.priceChangePercentage60dInCurrency?.get(currency)
                            )
                        coinViewModel.deleteCoin(coin)
                        coinViewModel.addCoin(coin)
                        counter++
                    }
                }


                /*result.enqueue( object : Callback<List<CoinList>> {
                    override fun onResponse(call: Call<List<CoinList>>?, response: Response<List<CoinList>>?) {
                        if (response?.body() != null){

                        }
                    }

                    override fun onFailure(call: Call<List<CoinList>>?, t: Throwable?) {

                    }
                })*/





            }
        }
    }
}