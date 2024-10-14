package ru.zatsoft.trainingsession

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.trainingsession.databinding.ActivityExecBinding


class ExecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExecBinding
    private lateinit var toolBar: Toolbar
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolBar = binding.toolbarMain
        setSupportActionBar(toolBar)
        title = " "

        val komplexes = Komplexes()
        var komplex = listOf<Exercise>()
        val nKomplex = intent.getIntExtra("komplex", -1)
        if ((nKomplex > -1) && (nKomplex < komplexes.komplex.size)) {
            komplex = komplexes.komplex[nKomplex]
        } else {
            Toast.makeText(this, "Ошибка выбора комплекса упражнений", Toast.LENGTH_LONG).show()
            System.exit(1)
        }
        listAdapter = ListAdapter(applicationContext, komplex)

        binding.listView.adapter = listAdapter
        binding.listView.setClickable(true)

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val exercise = listAdapter.getItem(position)
                val exerciseIntent = Intent(this, InfoActivity::class.java)
                exerciseIntent.putExtra("exercise", exercise as Exercise )
                startActivity(exerciseIntent)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exit)
            finishAffinity()
        return super.onOptionsItemSelected(item)
    }
}