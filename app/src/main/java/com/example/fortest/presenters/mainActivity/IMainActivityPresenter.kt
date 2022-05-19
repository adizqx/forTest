package com.example.fortest.presenters.mainActivity

import com.example.fortest.models.InventoryModel


interface IMainActivityPresenter {

    fun fabOnClick()
    fun insert(inventory: InventoryModel)
    fun getAllInventory(): List<InventoryModel>
    fun fetch()
    fun deletetaskFromDatabase(item: InventoryModel)
    fun updateItemFromDatabase(item: InventoryModel)
}