package com.example.cryptocurrency.Database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.cryptocurrency.DataModel.Coin
import java.lang.IllegalStateException
import java.util.concurrent.Executors

private const val DATABASE_NAME = "CryptoCurrency"

class CryptoCurrencyRepository private constructor(context: Context){

    //region Properties

    private val database : CryptoCurrencyDatabase = Room.databaseBuilder(
        context.applicationContext,
        CryptoCurrencyDatabase::class.java,
        DATABASE_NAME
    ).build()
    private val cryptoCurrencyDao = database.cryptoCurrencyDao()
    private val  executor = Executors.newSingleThreadExecutor()

    //endregion

    //region Initialize methods

    fun getCoins() : LiveData<List<Coin>> = cryptoCurrencyDao.getCoins()
    fun getCoins(id : String) : LiveData<Coin?> = cryptoCurrencyDao.getCoins(id)

    fun updateCoin(coin : Coin){
        executor.execute{
            cryptoCurrencyDao.updateCoin(coin)
        }
    }

    fun deleteCoin(coin : Coin){
        executor.execute{
            cryptoCurrencyDao.deleteCoin(coin)
        }
    }

    fun addCoin(coin: Coin){
        executor.execute{
            cryptoCurrencyDao.addCoin(coin)
        }
    }

    //endregion

    //region Constructor

    companion object{
        private var INSTANCE : CryptoCurrencyRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = CryptoCurrencyRepository(context)
            }
        }

        fun get() : CryptoCurrencyRepository{
            return INSTANCE?: throw IllegalStateException("CryptoCurrencyRepository must be initialize")
        }
    }

    //endregion
}