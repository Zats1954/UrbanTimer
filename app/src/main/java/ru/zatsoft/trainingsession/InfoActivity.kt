package ru.zatsoft.trainingsession

import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.trainingsession.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private lateinit var toolBar: Toolbar
    private lateinit var data: Exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolBar = binding.toolbarMain
        setSupportActionBar(toolBar)
        title = " "

        data = intent.getSerializableExtra("exercise") as Exercise
        val timer = object : CountDownTimer(
            data.timerEx * 1000L, 1000
        ) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = formatTime((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                binding.tvTimer.visibility = View.GONE
                binding.ButtonStart.visibility = View.VISIBLE
            }

        }
        binding.exerciseTitle.text = data.info.toString()
        binding.gifView.setImageResource(data.image)
        binding.ButtonStart.setOnClickListener {
            binding.tvTimer.visibility = View.VISIBLE
            binding.ButtonStart.visibility = View.GONE
            timer.start()
        }
    }

    private fun formatTime(time: Int): String {
        val minutes = time / 60
        val seconds = time % 60
        return String.format("осталось %02d:%02d", minutes, seconds)
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