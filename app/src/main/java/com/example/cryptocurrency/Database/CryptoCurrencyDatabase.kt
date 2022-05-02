package com.example.cryptocurrency.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cryptocurrency.Model.Coin
import androidx.sqlite.db.SupportSQLiteDatabase

import androidx.room.migration.Migration

@Database(entities = [Coin::class], version = 3)
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
                    )
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Create the new table
        database.execSQL(
            "CREATE TABLE [Coins_new] " +
                    "(" +
                    "[id] TEXT NOT NULL, " +
                    "[Description] TEXT NOT NULL, " +
                    "[CoingeckoRank] INTEGER NULL, " +
                    "[CurrentPriceUSD] REAL NULL, " +
                    "[PriceChangePer1Hour] REAL NULL, " +
                    "[PriceChangePer24Hour] REAL NULL, " +
                    "[PriceChangePer7Days] REAL NULL," +
                    "[PriceChangePer14Days] REAL NULL, " +
                    "[PriceChangePer30Days] REAL NULL, " +
                    "[PriceChangePer60Days] REAL NULL," +
                    "PRIMARY KEY([id])" +
                    ")"
        )
        // Copy the data
        database.execSQL(
            "INSERT INTO [Coins_new] " +
                    "(" +
                    "[id]," +
                    "[Description]," +
                    "[CoingeckoRank]," +
                    "[CurrentPriceUSD]," +
                    "[PriceChangePer1Hour]," +
                    "[PriceChangePer24Hour]," +
                    "[PriceChangePer7Days]," +
                    "[PriceChangePer14Days]," +
                    "[PriceChangePer30Days]," +
                    "[PriceChangePer60Days]" +
                    ")" +
                    " SELECT " +
                    "[id]," +
                    "[Description]," +
                    "[CoingeckoRank]," +
                    "[CurrentPriceUSD]," +
                    "[PriceChangePer1Hour]," +
                    "[PriceChangePer24Hour]," +
                    "[PriceChangePer7Days]," +
                    "[PriceChangePer14Days]," +
                    "[PriceChangePer30Days]," +
                    "[PriceChangePer60Days]" +
                    "FROM [Coins]"
        )
        // Remove the old table
        database.execSQL("DROP TABLE [Coins]")
        // Change the table name to the correct one
        database.execSQL("ALTER TABLE [Coins_new] RENAME TO [Coins]")
    }
}

val MIGRATION_2_3: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Create the new table
            database.execSQL(
                "CREATE TABLE [Coins_new] " +
                        "(" +
                        "[id] TEXT NOT NULL, " +
                        "[Name] TEXT NOT NULL," +
                        "[Description] TEXT NOT NULL, " +
                        "[CoingeckoRank] INTEGER NULL, " +
                        "[CurrentPriceUSD] REAL NULL, " +
                        "[PriceChangePer1Hour] REAL NULL, " +
                        "[PriceChangePer24Hour] REAL NULL, " +
                        "[PriceChangePer7Days] REAL NULL," +
                        "[PriceChangePer14Days] REAL NULL, " +
                        "[PriceChangePer30Days] REAL NULL, " +
                        "[PriceChangePer60Days] REAL NULL," +
                        "PRIMARY KEY([id])" +
                        ")")
            // Copy the data
            database.execSQL(
                "INSERT INTO [Coins_new] " +
                        "(" +
                        "[id]," +
                        "[Name]," +
                        "[Description]," +
                        "[CoingeckoRank]," +
                        "[CurrentPriceUSD]," +
                        "[PriceChangePer1Hour]," +
                        "[PriceChangePer24Hour]," +
                        "[PriceChangePer7Days]," +
                        "[PriceChangePer14Days]," +
                        "[PriceChangePer30Days]," +
                        "[PriceChangePer60Days]" +
                        ")" +
                        " SELECT " +
                        "[id]," +
                        "[id]," +
                        "[Description]," +
                        "[CoingeckoRank]," +
                        "[CurrentPriceUSD]," +
                        "[PriceChangePer1Hour]," +
                        "[PriceChangePer24Hour]," +
                        "[PriceChangePer7Days]," +
                        "[PriceChangePer14Days]," +
                        "[PriceChangePer30Days]," +
                        "[PriceChangePer60Days]" +
                        "FROM [Coins]")
            // Remove the old table
            database.execSQL("DROP TABLE [Coins]")
            // Change the table name to the correct one
            database.execSQL("ALTER TABLE [Coins_new] RENAME TO [Coins]")
        }
}
