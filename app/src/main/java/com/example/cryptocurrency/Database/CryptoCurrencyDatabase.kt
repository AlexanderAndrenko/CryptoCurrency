package com.example.cryptocurrency.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptocurrency.DataModel.Coin

@Database(entities = [Coin::class], version = 1)
abstract class CryptoCurrencyDatabase : RoomDatabase() {

    abstract fun cryptoCurrencyDao() : CryptoCurrencyDao
}