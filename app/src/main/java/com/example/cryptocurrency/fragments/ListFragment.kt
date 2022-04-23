package com.example.cryptocurrency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        /*
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val bAdd : View = view.findViewById(R.id.floatingActionButton)

        bAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }*/

        return binding.root
    }
}