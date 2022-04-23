package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrency.Database.CoinViewModel
import com.example.cryptocurrency.R

class AddFragment : Fragment() {

    private lateinit var mCoinViewModel : CoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mCoinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)

        var addButton : Button = view.findViewById(R.id.add)

        addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        /*val nameET : EditText = view.findViewById(R.id.name_et)
        val name = */
    }
}