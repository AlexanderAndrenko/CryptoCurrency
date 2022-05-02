package com.example.cryptocurrency.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cryptocurrency.Model.Coin
import retrofit2.http.DELETE

@Dao
interface CryptoCurrencyDao {
    /*Get a list of cryptocurrencies*/
    @Query("SELECT * FROM coins ORDER BY CoingeckoRank")
    fun getCoins(): LiveData<List<Coin>>

    /*Get a specific coin*/
    @Query("SELECT * FROM coins WHERE id = :id ORDER BY CoingeckoRank")
    fun getCoins(id: String): LiveData<Coin?>

    @Update
    suspend fun updateCoin(coin : Coin)

    /*Delete a specific coin*/
    @Delete
    suspend fun deleteCoin(coin: Coin)

    /*Insert a coin*/
    @Insert
    suspend fun addCoin(coin: Coin)
}