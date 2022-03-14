package com.rtorres.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rtorres.basketballscore.databinding.ActivityScoreBinding
import kotlinx.android.synthetic.main.activity_result.*

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    private lateinit var viewModel: ScoreViewModel

    companion object {
        const val FIRST_TEAM = "team1"
        const val SECOND_TEAM = "team2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        val bundle = intent.extras!!
        viewModel.renameTeam1(bundle.getString(FIRST_TEAM)!!)
        viewModel.renameTeam2(bundle.getString(SECOND_TEAM)!!)
        binding.firstTeamName.text = viewModel.team1
        binding.secondTeamName.text = viewModel.team2

        binding.plus2Button1.setOnClickListener {
            viewModel.addToScore1(2)
            binding.scoreTeam1.text = viewModel.scoreTeam1.toString()
        }

        binding.plus3Button1.setOnClickListener {
            viewModel.addToScore1(3)
            binding.scoreTeam1.text = viewModel.scoreTeam1.toString()
        }
        binding.minusButton1.setOnClickListener {
            viewModel.substractToScre1(1)
            binding.scoreTeam1.text = viewModel.scoreTeam1.toString()
        }

        binding.plus2Button2.setOnClickListener {
            viewModel.addToScore2(2)
            binding.scoreTeam2.text = viewModel.scoreTeam2.toString()
        }

        binding.plus3Button2.setOnClickListener {
            viewModel.addToScore2(3)
            binding.scoreTeam2.text = viewModel.scoreTeam2.toString()
        }
        binding.minusButton2.setOnClickListener {
            viewModel.substractToScre2(1)
            binding.scoreTeam2.text = viewModel.scoreTeam2.toString()
        }

        binding.resetButton.setOnClickListener {
            viewModel.substractToScre1(viewModel.scoreTeam1)
            viewModel.substractToScre2(viewModel.scoreTeam2)
            binding.scoreTeam1.text = viewModel.scoreTeam1.toString()
            binding.scoreTeam2.text = viewModel.scoreTeam2.toString()
        }

        binding.finishButton.setOnClickListener {
            openResultActivity(
                viewModel.team1,
                viewModel.team2,
                viewModel.scoreTeam1,
                viewModel.scoreTeam2
            )
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