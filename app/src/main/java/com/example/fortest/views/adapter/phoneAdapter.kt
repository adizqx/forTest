package com.example.fortest.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fortest.R
import com.example.fortest.models.PhoneNumber

class phoneAdapter():RecyclerView.Adapter<phoneAdapter.PhoneViewHolder>() {
    private val list = arrayListOf<PhoneNumber>()

    fun setData(list: ArrayList<PhoneNumber>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class PhoneViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvName =  itemView.findViewById<TextView>(R.id.tvName)
        val tvPhoneNumber =  itemView.findViewById<TextView>(R.id.tvPhoneNumber)
        val photo =  itemView.findViewById<ImageView>(R.id.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val item = list[position]
        holder.tvName.text = item.name
        holder.tvPhoneNumber.text = item.phoneNumber
        Glide.with(holder.itemView).load(item.photo).into(holder.photo)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}