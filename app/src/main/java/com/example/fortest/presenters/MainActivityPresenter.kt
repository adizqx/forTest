package com.example.fortest.presenters

import com.example.fortest.MainActivityView
import com.example.fortest.models.User

class MainActivityPresenter(val view:MainActivityView,val user: User):IMainActivityPresenter {
    override fun onBtnClick() {
        val name = view.getNameEditText()
        val lastName = view.getLastNameEditText()
        view.setName(name)
        view.setLastName(lastName)
    }

    override fun NameOnChangeListener() {
        view.setName(view.getNameEditText())
    }

    override fun lastNameOnChangeListener() {
        view.setLastName(view.getLastNameEditText())
    }
}