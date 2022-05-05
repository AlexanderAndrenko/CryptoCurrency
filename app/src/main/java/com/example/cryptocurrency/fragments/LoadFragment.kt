package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrency.APIclient.CoinGeckoClientAPI
import com.example.cryptocurrency.LoadParameters
import com.example.cryptocurrency.ViewModel.CoinViewModel
import com.example.cryptocurrency.databinding.FragmentLoadBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoadFragment : Fragment() {

    private lateinit var binding: FragmentLoadBinding
    private lateinit var mCoinViewModel: CoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoadBinding.inflate(layoutInflater)
        mCoinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)

        binding.startBtn.setOnClickListener{
            GlobalScope.launch {
                LoadParameters.StartLoadData(mCoinViewModel)
            }
            binding.status.text = "Execute"
        }

        binding.stopBtn.setOnClickListener{
            GlobalScope.launch {
                InterruptExecution()
            }
            binding.status.text = "Stop"
        }

        binding.status.text = "Launch process"

        return binding.root
    }

    suspend fun InterruptExecution(){
        LoadParameters.StopLoadData()
    }
}