package com.example.fortest.presenters.addActivity

import com.example.fortest.db.models.Inventory
import com.example.fortest.repository.MainRepository
import com.example.fortest.views.addActivity.IAddView

class AddPresenter(private val iAddView: IAddView): IAddPresenter {
    private val repository = MainRepository()
    override suspend fun inserted(inventory: Inventory) {
        iAddView.inserted()
        repository.insert(inventory)
    }

    override suspend fun updated(inventory: Inventory) {
        iAddView.updated()
        repository.update(inventory)
    }


}