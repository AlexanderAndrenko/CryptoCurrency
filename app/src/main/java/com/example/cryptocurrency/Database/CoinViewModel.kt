package com.example.cryptocurrency.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.DataModel.Coin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinViewModel(application: Application): AndroidViewModel(application) {
    val getCoins: LiveData<List<Coin>>
    private val repository: CryptoCurrencyRepository

    init{
        val cryptoCurrencyDao = CryptoCurrencyDatabase.getDatabase(application).cryptoCurrencyDao()
        repository = CryptoCurrencyRepository(cryptoCurrencyDao)
        getCoins = repository.getCoins
    }

    fun addCoin(coin: Coin){
        viewModelScope.launch (Dispatchers.IO){
            repository.addCoin(coin)
        }
    }
}