package com.example.cryptocurrency.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.DataModel.Coin
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FragmentAddBinding
import com.example.cryptocurrency.databinding.FragmentListCustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var coinList = emptyList<Coin>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.nameCurrency)
        val rank : TextView = itemView.findViewById(R.id.rankCoinGecko)
        val currentPrice : TextView = itemView.findViewById(R.id.currentPrice)
        val oneHour : TextView = itemView.findViewById(R.id.priceCP1hour)
        val oneDay : TextView = itemView.findViewById(R.id.priceCP24hour)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = coinList[position]

        holder.name.text = currentItem.id.toString()
        holder.rank.text = currentItem.coingeckoRank.toString()
        holder.currentPrice.text = currentItem.currentPrice.toString()
        holder.oneHour.text = currentItem.priceCP1H.toString()
        holder.oneDay.text = currentItem.priceCP24H.toString()
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    fun setData(coin : List<Coin>){
        this.coinList = coin
        notifyDataSetChanged()
    }
}