package com.example.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.menus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.popmenuBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, com.example.menus.PopupMenu::class.java))
        }

        binding.contextMenuBtn?.setOnClickListener {
            startActivity(Intent(this@MainActivity, com.example.menus.FloatingContextMenu::class.java))
        }

        binding.contextualBtn?.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContextualMenu::class.java))
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
            }

            R.id.settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            }

            R.id.subscribe -> {
                Toast.makeText(this, "Subscribe", Toast.LENGTH_LONG).show()
            }

            R.id.logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }

            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
}