package com.example.fortest.views.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fortest.databinding.ItemBinding
import com.example.fortest.db.models.Inventory


class ItemAdapter() :
    RecyclerView.Adapter<ItemAdapter.InventoryViewHolder>() {

    inner class InventoryViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    private val differCalback = object : DiffUtil.ItemCallback<Inventory>() {
        override fun areItemsTheSame(oldItem: Inventory, newItem: Inventory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Inventory, newItem: Inventory): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCalback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.InventoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return InventoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.InventoryViewHolder, position: Int) {
        val current = differ.currentList[position]
        holder.binding.let {
            it.category.text = current.categoryName
            it.title.text = current.title
            it.quantity.text = current.quantity.toString()
            it.image.setImageURI(Uri.parse(current.photo))
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}