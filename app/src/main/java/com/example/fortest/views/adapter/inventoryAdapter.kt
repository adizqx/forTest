package com.example.fortest.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fortest.R
import com.example.fortest.databinding.ItemBinding
import com.example.fortest.models.InventoryModel


class inventoryAdapter(var list: MutableList<InventoryModel>, var itemClicked: OnItemClicked) :
    RecyclerView.Adapter<inventoryAdapter.InventoryViewHolder>() {

    inner class InventoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemBinding.bind(itemView)
        fun bind(item: InventoryModel) = with(binding) {
            tvName.text = item.name
            tvAmount.text = item.amount
            Glide.with(itemView).load(item.photo).into(photo)
            ibUpdate.setOnClickListener {
                itemClicked.update(item, adapterPosition)
            }
        }
        init {
            binding.ibDelete.setOnClickListener {
                itemClicked.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryViewHolder {
        return InventoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: InventoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun deleteItem(position: Int) {
        list.removeAt(position)
        this.notifyItemRemoved(position)
        this.notifyDataSetChanged()
    }

    fun updateItem(position: Int) {
        this.notifyItemChanged(position)
        this.notifyDataSetChanged()
    }
}