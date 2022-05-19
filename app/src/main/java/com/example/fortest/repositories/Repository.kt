package com.example.fortest.repositories

import com.example.fortest.App
import com.example.fortest.models.InventoryModel


class Repository {
    private val db = App.instance
    private val dao = db?.getDb()?.InventoryDao()

    init {
        getAllInventory()
    }

    fun insert(inventory: InventoryModel) {
        dao?.insertInventory(inventory)
    }

    fun getAllInventory(): List<InventoryModel> {
        return dao!!.getAllInventory()
    }

    fun deletetaskFromDatabase(item: InventoryModel) {
        dao?.deleteInventory(item)
    }

    fun updateItem(item: InventoryModel) {
        dao?.updateInventory(item)
    }
}