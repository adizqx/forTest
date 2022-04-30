package com.example.fortest.presenters.mainActivity

import androidx.lifecycle.MutableLiveData
import com.example.fortest.models.PhoneNumber
import com.example.fortest.repositories.Repository
import com.example.fortest.views.mainActivity.IMainActivityView


class MainActivityPresenter(val view: IMainActivityView) : IMainActivityPresenter {

    private val repository = Repository()

    init {
        getAllContats()
        fetch()
    }

    override fun getAllContats(): List<PhoneNumber> {
        return repository.getAllContacts()
    }

    override fun fetch() {
        view.setRecyclerView(getAllContats())
    }

    override fun fabOnClick() {
        view.showAlertDialog("text", "test")
    }

    override fun insert(phoneNumber: PhoneNumber) {
        repository.insert(phoneNumber)
    }


}