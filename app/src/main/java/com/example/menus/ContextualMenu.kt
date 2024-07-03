package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.menus.databinding.ActivityContextualMenuBinding

class ContextualMenu : AppCompatActivity() {
    private val binding by lazy {
        ActivityContextualMenuBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar4)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar4.setNavigationOnClickListener { onBackPressed() }

        val actionCallBack = object : ActionMode.Callback{
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.contextual_menu_items,menu)
                binding.toolbar4.visibility = View.GONE
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return true
            }


            /** Action call back for Contextual Menu**/
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.contexual_option_1 -> {
                        Toast.makeText(this@ContextualMenu, "contextual menu 1", Toast.LENGTH_SHORT).show()
                    }
                    R.id.contexual_option_2 -> {
                        Toast.makeText(this@ContextualMenu, "contextual menu 2", Toast.LENGTH_SHORT).show()
                    }
                    R.id.contexual_option_3 -> {
                        Toast.makeText(this@ContextualMenu, "contextual menu 3", Toast.LENGTH_SHORT).show()
                    }
                }
                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                binding.toolbar4.visibility = View.VISIBLE
            }

        }

        binding.contextualMenuBtn.setOnClickListener {
            startActionMode(actionCallBack)
        }

    }
}