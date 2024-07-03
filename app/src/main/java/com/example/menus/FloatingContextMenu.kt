package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.menus.databinding.ActivityFloatingContextMenuBinding

class FloatingContextMenu : AppCompatActivity() {
    private val binding by lazy{
        ActivityFloatingContextMenuBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar2.setNavigationOnClickListener {
            onBackPressed()
        }


        // fist register for context menu
        registerForContextMenu(binding.contextMenuBtn)
        binding.contextMenuBtn.setOnClickListener {
            openContextMenu(binding.contextMenuBtn)
        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.floating_context_menu_items,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.context_1 -> {
                Toast.makeText(this@FloatingContextMenu, "Context menu 1", Toast.LENGTH_SHORT).show()
            }
            R.id.context_2 -> {
                Toast.makeText(this@FloatingContextMenu, "Context menu 2", Toast.LENGTH_SHORT).show()
            }
            R.id.context_3 -> {
                Toast.makeText(this@FloatingContextMenu, "Context menu 3", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
}