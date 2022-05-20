package com.example.fortest.presenters.addActivity

import com.example.fortest.db.models.Inventory

interface IAddPresenter {
    suspend fun inserted(inventory: Inventory)

    suspend fun updated(inventory: Inventory)
}