package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.ViewModel.CoinViewModel
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var mCoinViewModel : CoinViewModel
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_add, container, false)

        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.add.setOnClickListener {
            insertDataToDatabase()
        }

        mCoinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)


        return binding.root
    }

    private fun insertDataToDatabase() {
        val name = binding.nameEt.text.toString()
        val description = binding.descriptionEt.text.toString()
        val rankCoinGecko : Int = binding.coinGeckoRankEt.text.toString().toInt()

       /* val coin = Coin("test" ,name, description, rankCoinGecko, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)
        mCoinViewModel.addCoin(coin)*/
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }
}