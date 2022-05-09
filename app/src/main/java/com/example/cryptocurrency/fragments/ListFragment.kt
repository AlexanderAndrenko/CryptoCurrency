package com.example.cryptocurrency.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.APIclient.model.coins.CoinList
import com.example.cryptocurrency.LoadParameters
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.ViewModel.CoinViewModel
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentListBinding
import kotlinx.coroutines.*

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mCoinViewModel: CoinViewModel
    private lateinit var adapter : ListAdapter
    private lateinit var update : Job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        adapter = ListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        mCoinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        mCoinViewModel.getCoins.observe(viewLifecycleOwner, Observer { coin -> adapter.setData(coin) })
        binding.floatingActionButton.setOnClickListener {
            UpdateData()
            Log.d("Debug ListFragment", "Click to Update Button")
            /*findNavController().navigate(R.id.action_listFragment_to_loadFragment)*/
        }
        return binding.root
    }

    override fun onResume() {
        Log.d("Debug ListFragment", "On RESUME")
        super.onResume()
    }

    override fun onStart() {
        Log.d("Debug ListFragment", "On START")
        super.onStart()
    }

    fun UpdateData(){
        Log.d("Debug ListFragment", "START update")
        /*update =
        GlobalScope.launch {
            LoadParameters.StartLoadData(mCoinViewModel)
        }*/
        LoadParameters.StartLoadData(mCoinViewModel)
        Log.d("Debug ListFragment", "Coroutine START")
        //update.start()
    }
}