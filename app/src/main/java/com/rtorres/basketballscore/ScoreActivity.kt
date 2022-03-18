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

        binding.scoreViewModel = viewModel

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

        binding.finishButton.setOnClickListener {
            openResultActivity()
        }
    }


    private fun openResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.SCORE1, viewModel.scoreTeam1LiveData.value)
        intent.putExtra(ResultActivity.SCORE2, viewModel.scoreTeam2LiveData.value)
        intent.putExtra(ResultActivity.TEAM1, viewModel.team1.value)
        intent.putExtra(ResultActivity.TEAM2, viewModel.team2.value)
        startActivity(intent)
    }
}