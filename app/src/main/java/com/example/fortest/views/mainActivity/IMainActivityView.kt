package com.example.fortest.views.mainActivity

import com.example.fortest.models.InventoryModel

interface IMainActivityView {
    fun setRecyclerView(array: List<InventoryModel>)
    fun showAlertDialog()
}