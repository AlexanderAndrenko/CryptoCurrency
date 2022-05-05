package com.example.cryptocurrency.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.Database.CryptoCurrencyDatabase
import com.example.cryptocurrency.Database.CryptoCurrencyRepository
import com.example.cryptocurrency.Model.Coin
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

    fun deleteCoin(coin: Coin){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteCoin(coin)
        }
    }
}