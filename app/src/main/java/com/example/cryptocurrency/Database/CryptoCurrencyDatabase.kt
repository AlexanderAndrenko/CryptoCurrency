package com.example.cryptocurrency.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cryptocurrency.DataModel.Coin

@Database(entities = [Coin::class], version = 1)
@TypeConverters(CryptoCurrencyTypeConverter::class)
abstract class CryptoCurrencyDatabase : RoomDatabase() {

    abstract fun cryptoCurrencyDao() : CryptoCurrencyDao

    companion object{
        @Volatile
        private var INSTANCE: CryptoCurrencyDatabase? = null

        fun getDatabase(context: Context): CryptoCurrencyDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoCurrencyDatabase::class.java,
                    "cryptoCurrency"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}