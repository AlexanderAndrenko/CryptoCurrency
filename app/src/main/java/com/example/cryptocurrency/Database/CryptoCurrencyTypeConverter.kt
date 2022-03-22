package com.example.cryptocurrency.Database

import androidx.room.TypeConverter
import java.util.*

class CryptoCurrencyTypeConverter {
    @TypeConverter
    fun fromDate(date : Date?) : Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?) : Date?{
        return millisSinceEpoch?.let{ Date(it) }
    }
}