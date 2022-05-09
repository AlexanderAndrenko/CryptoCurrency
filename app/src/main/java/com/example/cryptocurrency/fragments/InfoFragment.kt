package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentInfoBinding
import kotlin.math.round

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val args by navArgs<InfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)

        binding.nameCurrencyInfo.text = args.currentCoin.name
        binding.maxprice.text = "$" + args.currentCoin.maxPrice.toString()
        binding.maxpricedate.text = args.currentCoin.maxPriceDate.toString().subSequence(0,10)
        binding.coinGeckoRankInfo.text = args.currentCoin.coingeckoRank.toString()
        binding.currentPriceinfo.text = "$" + args.currentCoin.currentPrice.toString()
        binding.priceCP1hourInfo.text = (Math.round(args.currentCoin.priceCP1H!! * 100).toDouble() / 100).toString() + " %"
        binding.priceCP24hourinfo.text = (Math.round(args.currentCoin.priceCP24H!! * 100).toDouble() / 100).toString() + " %"
        binding.priceCP7daysInfo.text = (Math.round(args.currentCoin.priceCP7D!! * 100).toDouble() / 100).toString() + " %"
        binding.priceCP14daysInfo.text = (Math.round(args.currentCoin.priceCP14D!! * 100).toDouble() / 100).toString() + " %"
        binding.priceCP30daysInfo.text = (Math.round(args.currentCoin.priceCP30D!! * 100).toDouble() / 100).toString() + " %"
        binding.priceCP200daysInfo.text = (Math.round(args.currentCoin.priceCP200D!! * 100).toDouble() / 100).toString() + " %"

        return binding.root
    }
}