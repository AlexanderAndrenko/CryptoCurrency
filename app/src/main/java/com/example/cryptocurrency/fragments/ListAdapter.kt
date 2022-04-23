package com.example.cryptocurrency.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.DataModel.Coin
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentAddBinding
import com.example.cryptocurrency.databinding.FragmentListCustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var coinList = emptyList<Coin>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       /* val name = holder.findViewById(R.id.nameCurrency)
        val rank = holder.findViewById(R.id.rankCoinGecko)
        val currentPrice = holder.findViewById(R.id.currentPrice)
        val oneHour = holder.findViewById(R.id.priceCP1hour)
        val oneDay = holder.findViewById(R.id.priceCP24hour)

        val currentItem = coinList[position]

        name.text = currentItem.id.toString()
        rank.text = currentItem.coingeckoRank
        currentPrice.text = currentItem.currentPrice
        oneHour.text = currentItem.priceCP1H
        oneDay.text = currentItem.priceCP24H*/
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}