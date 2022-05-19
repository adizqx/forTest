package com.example.fortest.views.mainActivity

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fortest.R
import com.example.fortest.databinding.ActivityMainBinding
import com.example.fortest.databinding.AlertItemBinding
import com.example.fortest.databinding.AlertUpdateBinding
import com.example.fortest.models.InventoryModel
import com.example.fortest.presenters.mainActivity.IMainActivityPresenter
import com.example.fortest.presenters.mainActivity.MainActivityPresenter
import com.example.fortest.views.adapter.OnItemClicked
import com.example.fortest.views.adapter.inventoryAdapter

class MainActivity : AppCompatActivity(), IMainActivityView {

    lateinit var binding: ActivityMainBinding
    lateinit var presenter: IMainActivityPresenter
    private var myadapter: inventoryAdapter? = null

   private var indexImage = 0
   private var imageId = R.drawable.antigrip
   private val imageList = listOf(R.drawable.antigrip,R.drawable.aspirin,R.drawable.cardiomagnil,R.drawable.pikovit,
        R.drawable.solpadein,R.drawable.alfavit,R.drawable.calcium)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)

        binding.fabtn.setOnClickListener {
            presenter.fabOnClick()
        }
    }


    override fun setRecyclerView(array: List<InventoryModel>) {
        myadapter = inventoryAdapter(array as MutableList<InventoryModel>, object : OnItemClicked {
            override fun onClick(position: Int) {
                myadapter?.list?.get(position)?.let { presenter.deletetaskFromDatabase(it)
                 }
                myadapter?.deleteItem(position)
            }

            override fun update(item: InventoryModel,position: Int) {
                showUpdateAlert(item,position)
            }
        })
        binding.rcView.adapter = myadapter
    }

    private fun showUpdateAlert(item: InventoryModel,position:Int) {
        val customDialog = Dialog(this)
        val updateBinding = AlertUpdateBinding.inflate(layoutInflater)
        customDialog.setContentView(updateBinding.root)
       updateBinding.etName.setText(item.name)
       updateBinding.etAmount.setText(item.amount)

        updateBinding.btnNextImage.setOnClickListener {
            indexImage++
            if (indexImage > imageList.size - 1) indexImage = 0
            imageId = imageList[indexImage]
            updateBinding.image.setImageResource(imageId)
        }

        updateBinding.btnUpdate.setOnClickListener {
            val updatedInventory = InventoryModel(item.id, updateBinding.etName.text.toString(),
                updateBinding.etAmount.text.toString(), true, imageId)
            presenter.updateItemFromDatabase(updatedInventory)
            myadapter?.updateItem(position)
            customDialog.dismiss()
        }
        customDialog.show()
    }



    override fun showAlertDialog() {
        val addDialog = Dialog(this)
        val binding = AlertItemBinding.inflate(layoutInflater)
        addDialog.setContentView(binding.root)

        binding.btnNextImage.setOnClickListener {
            indexImage++
            if (indexImage > imageList.size - 1) indexImage = 0
            imageId = imageList[indexImage]
            binding.image.setImageResource(imageId)
        }

        binding.btnAdd.setOnClickListener {
            val inventory = InventoryModel(0, binding.etName.text.toString(),
                binding.etAmount.text.toString(), true, imageId)
            presenter.insert(inventory)
            presenter.fetch()
            addDialog.dismiss()
//            Log.i("asfsafasfas", "${presenter.getAllContats()}")
        }
        addDialog.show()

    }

}