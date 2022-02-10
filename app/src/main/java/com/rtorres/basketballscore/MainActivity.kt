package com.rtorres.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtorres.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.setOnClickListener {
            val firstTeam = binding.firstTeamEdit.text.toString()
            val secondTeam = binding.secondTeamEdit.text.toString()
            openScoreActivity(firstTeam, secondTeam)
        }
    }

    private fun openScoreActivity(firstTeam: String, secondTeam: String) {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.FIRST_TEAM, firstTeam)
        intent.putExtra(ScoreActivity.SECOND_TEAM, secondTeam)
        startActivity(intent)
    }
}