package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val args by navArgs<InfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)

        binding.nameCurrencyInfo.text = args.currentCoin.name
        binding.descriptionInfo.text = "TEST DESCRIPTION" //args.currentCoin.description
        binding.coinGeckoRankInfo.text = args.currentCoin.coingeckoRank.toString()
        binding.currentPriceinfo.text = args.currentCoin.currentPrice.toString()
        binding.priceCP1hourInfo.text = args.currentCoin.priceCP1H.toString()
        binding.priceCP24hourinfo.text = args.currentCoin.priceCP24H.toString()
        binding.priceCP7daysInfo.text = args.currentCoin.priceCP7D.toString()
        binding.priceCP14daysInfo.text = args.currentCoin.priceCP14D.toString()
        binding.priceCP30daysInfo.text = args.currentCoin.priceCP30D.toString()
        binding.priceCP60daysInfo.text = args.currentCoin.priceCP60D.toString()

        return binding.root
    }
}