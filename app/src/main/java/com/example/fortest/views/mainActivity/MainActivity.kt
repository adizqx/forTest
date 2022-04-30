package com.example.fortest.views.mainActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fortest.R
import com.example.fortest.databinding.ActivityMainBinding
import com.example.fortest.models.PhoneNumber
import com.example.fortest.presenters.mainActivity.IMainActivityPresenter
import com.example.fortest.presenters.mainActivity.MainActivityPresenter
import com.example.fortest.views.adapter.phoneAdapter

class MainActivity : AppCompatActivity(), IMainActivityView {

    lateinit var binding: ActivityMainBinding
    lateinit var presenter: IMainActivityPresenter
    private var myadapter: phoneAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)

        binding.fabtn.setOnClickListener {
            presenter.fabOnClick()
        }
    }


    override fun setRecyclerView(array: List<PhoneNumber>) {
        myadapter = phoneAdapter(array)
        binding.rcView.adapter = myadapter
    }

    override fun setupListeners() {

    }

    override fun addContactButton() {

    }

    override fun adapterItemOnClick() {

    }

    override fun showAlertDialog(title: String, body: String) {
        val infl = LayoutInflater.from(this)
        val view = infl.inflate(R.layout.alert_item, null)
        val name = view.findViewById<EditText>(R.id.etName)
        val lname = view.findViewById<EditText>(R.id.etLastName)
        val btn = view.findViewById<Button>(R.id.btnAdd)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setView(view)
//        alertDialog.setTitle(title)
//            .setMessage(body)
        val dialog = alertDialog.create()
        dialog.show()
        btn.setOnClickListener {
            val contact = PhoneNumber(
                0,
                name.text.toString(),
                lname.text.toString(),
                "https://source.unsplash.com/random/800x600"
            )
            presenter.insert(contact)
            presenter.fetch()
            dialog.dismiss()
//            Log.i("asfsafasfas", "${presenter.getAllContats()}")
        }
    }
}