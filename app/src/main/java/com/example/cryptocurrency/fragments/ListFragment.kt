package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.ViewModel.CoinViewModel
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentListBinding
import kotlinx.coroutines.CoroutineScope

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mCoinViewModel: CoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        val adapter = ListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        mCoinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        mCoinViewModel.getCoins.observe(viewLifecycleOwner, Observer { coin -> adapter.setData(coin) })


        binding.floatingActionButton.setOnClickListener {
            /*findNavController().navigate(R.id.action_listFragment_to_addFragment)*/
            val coinGeckoClientAPI = CoinGeckoClientAPI()
            coinGeckoClientAPI.getCoinList(mCoinViewModel)
        }
        return binding.root
    }
}