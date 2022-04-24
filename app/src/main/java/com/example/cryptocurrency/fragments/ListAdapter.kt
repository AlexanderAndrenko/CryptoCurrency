package com.example.cryptocurrency.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Model.Coin
import com.example.cryptocurrency.R

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var coinList = emptyList<Coin>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.nameCurrency)
        val rank : TextView = itemView.findViewById(R.id.rankCoinGecko)
        val currentPrice : TextView = itemView.findViewById(R.id.currentPrice)
        val oneHour : TextView = itemView.findViewById(R.id.priceCP1hour)
        val oneDay : TextView = itemView.findViewById(R.id.priceCP24hour)
        val rowLayout : ConstraintLayout = itemView.findViewById(R.id.rowLayout)
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

        holder.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToInfoFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    fun setData(coin : List<Coin>){
        this.coinList = coin
        notifyDataSetChanged()
    }
}