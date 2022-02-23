package com.rtorres.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtorres.basketballscore.databinding.ActivityResultBinding
import com.rtorres.basketballscore.databinding.ActivityScoreBinding

class ResultActivity : AppCompatActivity() {

    companion object{
        const val SCORE1 = "score1"
        const val SCORE2 = "score2"
        const val TEAM1 = "team1"
        const val TEAM2 = "team2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val team1 = bundle.getString(TEAM1)!!
        val team2 = bundle.getString(TEAM2)!!
        val score1 = bundle.getInt(SCORE1)
        val score2 = bundle.getInt(SCORE2)

        binding.team1.text = team1
        binding.team2.text = team2
        binding.score1.text = score1.toString()
        binding.score2.text = score2.toString()

        if (score1 > score2){
            binding.result.text = team1 + " ha ganado!"
        } else if (score2 > score1){
            binding.result.text = team2 + " ha ganado!"
        }else{
            binding.result.text = "Es un empate!"
        }
    }
}