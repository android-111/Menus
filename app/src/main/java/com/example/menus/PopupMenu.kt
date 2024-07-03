package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.example.menus.databinding.ActivityPopupMenuBinding

class PopupMenu : AppCompatActivity() {
    private val binding by lazy {
        ActivityPopupMenuBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar3)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar3.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.popupMenuBtn.setOnClickListener {
            showPopMenu(it)
        }

    }

    private fun showPopMenu(view: View?) {
        val popupMenu = android.widget.PopupMenu(this@PopupMenu,view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu_items,popupMenu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.option_1 ->{
                    Toast.makeText(this@PopupMenu, "Option 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option_2 ->{
                    Toast.makeText(this@PopupMenu, "Option 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option_3 ->{
                    Toast.makeText(this@PopupMenu, "Option 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}