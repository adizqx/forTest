package com.example.fortest.presenters.mainActivity

import com.example.fortest.db.models.Inventory

interface IMainPresenter {
    suspend fun getAllItems():List<Inventory>?

    suspend fun delete(inventory: Inventory)
}