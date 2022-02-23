package com.rtorres.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rtorres.basketballscore.databinding.ActivityScoreBinding
import kotlinx.android.synthetic.main.activity_result.*

class ScoreActivity : AppCompatActivity() {

    private var scoreTeam1 = 0
    private var scoreTeam2 = 0
    private var team1 = ""
    private var team2 = ""

    companion object {
        const val FIRST_TEAM = "team1"
        const val SECOND_TEAM = "team2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        this.team1 = bundle.getString(FIRST_TEAM)!!
        this.team2 = bundle.getString(SECOND_TEAM)!!
        binding.firstTeamName.text = this.team1
        binding.secondTeamName.text = this.team2

        binding.plus2Button1.setOnClickListener {
            addToScore1(2)
            binding.scoreTeam1.text = this.scoreTeam1.toString()
        }

        binding.plus3Button1.setOnClickListener {
            addToScore1(3)
            binding.scoreTeam1.text = this.scoreTeam1.toString()
        }
        binding.minusButton1.setOnClickListener {
            substractToScre1(1)
            binding.scoreTeam1.text = this.scoreTeam1.toString()
        }

        binding.plus2Button2.setOnClickListener {
            addToScore2(2)
            binding.scoreTeam2.text = this.scoreTeam2.toString()
        }

        binding.plus3Button2.setOnClickListener {
            addToScore2(3)
            binding.scoreTeam2.text = this.scoreTeam2.toString()
        }
        binding.minusButton2.setOnClickListener {
            substractToScre2(1)
            binding.scoreTeam2.text = this.scoreTeam2.toString()
        }

        binding.resetButton.setOnClickListener {
            substractToScre1(this.scoreTeam1)
            substractToScre2(this.scoreTeam2)
            binding.scoreTeam1.text = this.scoreTeam1.toString()
            binding.scoreTeam2.text = this.scoreTeam2.toString()
        }

        binding.finishButton.setOnClickListener {
            openResultActivity(
                this.team1,
                this.team2,
                this.scoreTeam1,
                this.scoreTeam2
            )
        }
    }

    private fun addToScore1(number: Int) {
        this.scoreTeam1 += number
    }

    private fun substractToScre1(number: Int) {
        if (scoreTeam1 > 0) {
            this.scoreTeam1 -= number
        }
    }

    private fun addToScore2(number: Int) {
        this.scoreTeam2 += number
    }

    private fun substractToScre2(number: Int) {
        if (scoreTeam2 > 0) {
            this.scoreTeam2 -= number
        }
    }

    private fun openResultActivity(team1: String, team2: String, score1: Int, score2: Int) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.SCORE1, score1)
        intent.putExtra(ResultActivity.SCORE2, score2)
        intent.putExtra(ResultActivity.TEAM1, team1)
        intent.putExtra(ResultActivity.TEAM2, team2)
        startActivity(intent)
    }
}