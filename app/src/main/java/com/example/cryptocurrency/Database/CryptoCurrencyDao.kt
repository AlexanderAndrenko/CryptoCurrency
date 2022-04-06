package com.example.cryptocurrency.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cryptocurrency.DataModel.Coin

@Dao
interface CryptoCurrencyDao {
    /*Get a list of cryptocurrencies*/
    @Query("SELECT * FROM coins")
    fun getCoins(): LiveData<List<Coin>>

    /*Get a specific coin*/
    @Query("SELECT * FROM coins WHERE id = :id")
    fun getCoins(id: String): LiveData<Coin?>

    @Update
    fun updateCoin(coin : Coin)

    /*Delete a specific coin*/
    @Delete
    fun deleteCoin(coin: Coin)

    /*Insert a coin*/
    @Insert
    fun addCoin(coin: Coin)
}