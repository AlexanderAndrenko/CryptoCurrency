package com.example.cryptocurrency.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cryptocurrency.DataModel.Coin

@Database(entities = [Coin::class], version = 1)
@TypeConverters(CryptoCurrencyTypeConverter::class)
abstract class CryptoCurrencyDatabase : RoomDatabase() {

    abstract fun cryptoCurrencyDao() : CryptoCurrencyDao
}