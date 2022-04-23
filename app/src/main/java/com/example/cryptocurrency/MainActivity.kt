package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.Database.CryptoCurrencyRepository
import com.example.cryptocurrency.ViewModel.CryptoCurrencyListFragment
import com.example.cryptocurrency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBarWithNavController(findNavController(R.id.fragment))
    }
}