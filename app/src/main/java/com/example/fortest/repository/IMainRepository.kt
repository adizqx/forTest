package com.example.fortest.repository

import com.example.fortest.db.models.Inventory

interface IMainRepository {
    suspend fun update(inventory: Inventory)

    suspend fun insert(inventory: Inventory)

    suspend fun delete(inventory: Inventory)

    suspend fun getAll(): List<Inventory>?
}