package com.example.fortest.presenters.mainActivity

import com.example.fortest.models.InventoryModel
import com.example.fortest.repositories.Repository
import com.example.fortest.views.mainActivity.IMainActivityView


class MainActivityPresenter(val view: IMainActivityView) : IMainActivityPresenter {

    private val repository = Repository()

    init {
        getAllInventory()
        fetch()
    }

    override fun getAllInventory(): List<InventoryModel> {
        return repository.getAllInventory()
    }

    override fun fetch() {
        view.setRecyclerView(getAllInventory())
    }

    override fun deletetaskFromDatabase(item: InventoryModel) {
        repository.deletetaskFromDatabase(item)
    }

    override fun updateItemFromDatabase(item: InventoryModel) {
        repository.updateItem(item)
    }


    override fun fabOnClick() {
        view.showAlertDialog()
    }

    override fun insert(inventoryModel: InventoryModel) {
        repository.insert(inventoryModel)
    }


}