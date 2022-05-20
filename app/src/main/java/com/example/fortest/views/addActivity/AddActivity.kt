package com.example.fortest.views.addActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.fortest.R
import com.example.fortest.databinding.ActivityAddBinding
import com.example.fortest.db.models.Inventory
import com.example.fortest.presenters.addActivity.AddPresenter
import com.example.fortest.views.mainActivity.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity(),IAddView {
    private var binding: ActivityAddBinding? = null
    private val presenter by lazy { AddPresenter(this) }
    private var imageUri:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        openGallery()
        insert()
    }

    private fun insert() {
        binding?.add?.setOnClickListener {
            val inventory = Inventory(0,
                binding?.title?.text.toString(), binding?.quantity?.text.toString().toInt(),
                binding?.category?.text.toString(), imageUri ?: "")

            CoroutineScope(Dispatchers.IO).launch {
                presenter.inserted(inventory)
            }
            startActivity(Intent(this,MainActivity::class.java))
        }


    }

    private fun openGallery() {
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                imageUri = result.data.toString()
                binding?.image?.setImageURI(data?.data)
            }
        }
        binding?.image?.setOnClickListener {
            val intent = Intent()
            intent.type = "imgae/*"
            intent.action = Intent.ACTION_GET_CONTENT
            resultLauncher.launch(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun updated() {
        Toast.makeText(this, "Successfully updated", Toast.LENGTH_SHORT).show()
    }

    override fun inserted() {
        Toast.makeText(this, "Successfully inserted", Toast.LENGTH_SHORT).show()
    }
}