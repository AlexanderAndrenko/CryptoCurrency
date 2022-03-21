package com.example.cryptocurrency.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cryptocurrency.DataModel.Coin

@Dao
interface CryptoCurrencyDao {
    /*Get a list of cryptocurrencies*/
    @Query("SELECT * FROM coins")
    fun gettingCoins(): LiveData<List<Coin>>

    /*Get a specific coin*/
    @Query("SELECT * FROM coins WHERE id = :id")
    fun gettingCoins(id: String): LiveData<Coin?>

    /*Delete a specific coin*/
    @Delete
    fun deleteCoin(coin: Coin)

    /*Insert a coin*/
    @Insert
    fun addCoin(coin: Coin)
}