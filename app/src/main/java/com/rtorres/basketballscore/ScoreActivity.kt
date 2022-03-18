package com.rtorres.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rtorres.basketballscore.databinding.ActivityScoreBinding

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

        viewModel.scoreTeam1LiveData.observe(this, Observer { scoreTeamValue1 ->
            binding.scoreTeam1.text = scoreTeamValue1.toString()
        })

        viewModel.scoreTeam2LiveData.observe(this, Observer { scoreTeamValue2 ->
            binding.scoreTeam2.text = scoreTeamValue2.toString()
        })


        val bundle = intent.extras!!
        viewModel.renameTeam1(bundle.getString(FIRST_TEAM)!!)
        viewModel.renameTeam2(bundle.getString(SECOND_TEAM)!!)
        binding.firstTeamName.text = viewModel.team1.value
        binding.secondTeamName.text = viewModel.team2.value

        binding.plus2Button1.setOnClickListener {
            viewModel.addToScore1(2)
        }

        binding.plus3Button1.setOnClickListener {
            viewModel.addToScore1(3)
        }
        binding.minusButton1.setOnClickListener {
            viewModel.substractToScre1(1)
        }

        binding.plus2Button2.setOnClickListener {
            viewModel.addToScore2(2)
        }

        binding.plus3Button2.setOnClickListener {
            viewModel.addToScore2(3)
        }
        binding.minusButton2.setOnClickListener {
            viewModel.substractToScre2(1)
        }

        binding.resetButton.setOnClickListener {
            viewModel.substractToScre1(viewModel.scoreTeam1LiveData.value!!)
            viewModel.substractToScre2(viewModel.scoreTeam2LiveData.value!!)
        }

        binding.finishButton.setOnClickListener {
            openResultActivity(
                viewModel.team1.value!!,
                viewModel.team2.value!!,
                viewModel.scoreTeam1LiveData.value!!,
                viewModel.scoreTeam2LiveData.value!!
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