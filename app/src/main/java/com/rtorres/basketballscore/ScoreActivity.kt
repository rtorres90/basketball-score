package com.rtorres.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtorres.basketballscore.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    companion object {
        const val FIRST_TEAM = ""
        const val SECOND_TEAM = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val firstTeam = bundle.getString(FIRST_TEAM)!!
        binding.test.setText(firstTeam)
    }
}