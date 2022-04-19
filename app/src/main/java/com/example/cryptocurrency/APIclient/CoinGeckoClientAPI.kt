package com.example.cryptocurrency.APIclient

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val API_HOST = "api.coingecko.com"
private const val API_BASE_PATH = "/api/v3"


class CoinGeckoClientAPI {

    init{

    }

    private val httpClient = HttpClient(CIO).config {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            url.host = API_HOST
            url.encodedPath = API_BASE_PATH + url.encodedPath
        }
    }



    //suspend fun ping() = httpClient.get("ping")

    suspend fun getCoinList(includePlatform: Boolean): List<CoinList> =
        httpClient.get("coins/list") {
            parameter("include_platform", includePlatform)
        }
}