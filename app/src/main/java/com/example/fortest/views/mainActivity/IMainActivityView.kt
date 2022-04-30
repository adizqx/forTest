package com.example.fortest.views.mainActivity

import com.example.fortest.models.PhoneNumber

interface IMainActivityView {
    fun setRecyclerView(array: List<PhoneNumber>)
    fun setupListeners()
    fun addContactButton()
    fun adapterItemOnClick()
    fun showAlertDialog(title: String, body: String)
}