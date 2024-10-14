package ru.zatsoft.trainingsession

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import ru.zatsoft.trainingsession.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.toolbarMain
        setSupportActionBar(toolBar)
        title = " "

        var komplex = -1
        binding.button.setOnClickListener {
            if (komplex < 0) {
                Toast.makeText(this, "Выберете комплекс упражнений", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ExecActivity::class.java)
                intent.putExtra("komplex", komplex)
                startActivity(intent)
            }
        }

        binding.ll1.setOnClickListener {
            komplex = 0
            clearBackground()
            binding.ll1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
        }

        binding.ll2.setOnClickListener {
            komplex = 1
            clearBackground()
            binding.ll2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
        }

        binding.ll3.setOnClickListener {
            komplex = 2
            clearBackground()
            binding.ll3.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
        }
    }

    override fun onResume() {
        super.onResume()
        clearBackground()
    }

    private fun clearBackground() {
        binding.ll1.setBackgroundColor(Color.WHITE)
        binding.ll2.setBackgroundColor(Color.WHITE)
        binding.ll3.setBackgroundColor(Color.WHITE)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exit)
            finish()
        return super.onOptionsItemSelected(item)
    }

}