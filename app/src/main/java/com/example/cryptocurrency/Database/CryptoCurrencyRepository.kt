package com.example.cryptocurrency.Database
import androidx.lifecycle.LiveData
import com.example.cryptocurrency.Model.Coin

private const val DATABASE_NAME = "cryptoCurrency"

class CryptoCurrencyRepository(private val cryptoCurrencyDao: CryptoCurrencyDao){

    val getCoins: LiveData<List<Coin>> = cryptoCurrencyDao.getCoins()

    suspend fun addCoin(coin: Coin){
        cryptoCurrencyDao.addCoin(coin)
    }

    suspend fun deleteCoin(coin: Coin){
        cryptoCurrencyDao.deleteCoin(coin)
    }
}

//region Old Code
/*
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
        @Volatile
        private var INSTANCE : CryptoCurrencyRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = CryptoCurrencyRepository(context)
            }
        }

        fun get() : CryptoCurrencyRepository{
            return INSTANCE?: throw IllegalStateException("CryptoCurrencyRepository must be initialize")
            //synchronized()
        }
    }

    //endregion
}
*/
//endregion