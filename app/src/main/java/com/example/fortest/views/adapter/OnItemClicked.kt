package com.example.fortest.views.adapter

import com.example.fortest.models.InventoryModel

interface OnItemClicked {
    fun onClick(position: Int)
    fun update(item: InventoryModel, position: Int)
}