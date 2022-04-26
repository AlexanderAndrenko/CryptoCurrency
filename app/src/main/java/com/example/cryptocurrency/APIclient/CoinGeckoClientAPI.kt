package com.example.cryptocurrency.APIclient

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_HOST = "api.coingecko.com"
private const val API_BASE_PATH = "/api/v3"


class CoinGeckoClientAPI {

    fun getCoinList(){
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
                val result : Call<CoinGeckoResponse> = coinGeckoAPI.coingeckoContents()

                result.enqueue( object : Callback<CoinGeckoResponse> {
                    override fun onResponse(call: Call<CoinGeckoResponse>?, response: Response<CoinGeckoResponse>?) {
                        if (response?.body() != null){

                        }
                    }

                    override fun onFailure(call: Call<CoinGeckoResponse>?, t: Throwable?) {

                    }
                })
            }
        }
    }
}