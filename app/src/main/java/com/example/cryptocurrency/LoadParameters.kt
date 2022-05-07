package com.example.cryptocurrency

import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.ViewModel.CoinViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

object LoadParameters {
    private var downloader : Job? = null
    private var isExecute : Boolean = false

    fun StartLoadData(mCoinViewModel : CoinViewModel){
        downloader = GlobalScope.launch {
            val coinGeckoClientAPI = CoinGeckoClientAPI()
            coinGeckoClientAPI.getCoinList(mCoinViewModel)
            isExecute = true
        }
    }

    suspend fun StopLoadData(){
        if (downloader != null){
            downloader!!.cancel()
            downloader!!.join()
            isExecute = false
        }
    }

    fun GetStatusExecute() : Boolean{
        return isExecute
    }

    fun LoadIsOver(){
        isExecute = false
    }
}