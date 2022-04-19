package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.Database.CryptoCurrencyRepository
import com.example.cryptocurrency.ViewModel.CryptoCurrencyListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CryptoCurrencyIntentApplication()
        setContentView(R.layout.activity_main)
        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null)
        {
            val fragment = CryptoCurrencyListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }


    }

//    suspend fun getListcoin() {
//        var listCoins = CoinGeckoClientAPI.getCoinList(false)
//    }


}