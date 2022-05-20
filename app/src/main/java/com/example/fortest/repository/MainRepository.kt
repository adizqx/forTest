package com.example.fortest.repository

import com.example.fortest.App
import com.example.fortest.db.models.Inventory

class MainRepository : IMainRepository {

    val db = App.instance?.getDatabase()
    val dao = db?.dao()

    override suspend fun update(inventory: Inventory) {
        dao?.update(inventory)
    }

    override suspend fun insert(inventory: Inventory) {
        dao?.insert(inventory)
    }

    override suspend fun delete(inventory: Inventory) {
        dao?.delete(inventory)
    }

    override suspend fun getAll(): List<Inventory>? {
        return dao?.getAll()
    }
}