package com.example.fortest.presenters.mainActivity

import androidx.lifecycle.MutableLiveData
import com.example.fortest.db.models.Inventory
import com.example.fortest.repository.MainRepository
import com.example.fortest.views.mainActivity.IMainView


class MainPresenter(private val iMainView: IMainView) : IMainPresenter {
    val repository = MainRepository()

    override suspend fun getAllItems():List<Inventory>? {
       return repository.getAll()
    }

    override suspend fun delete(inventory: Inventory) {
        iMainView.showTextDeleted()
        repository.insert(inventory)
    }


}