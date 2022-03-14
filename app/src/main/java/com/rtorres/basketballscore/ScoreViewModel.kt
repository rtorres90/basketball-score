package com.rtorres.basketballscore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreTeam1: MutableLiveData<Int> = MutableLiveData()
    var scoreTeam2: MutableLiveData<Int> = MutableLiveData()
    var team1: MutableLiveData<String> = MutableLiveData()
    var team2: MutableLiveData<String> = MutableLiveData()


    init {
        scoreTeam1.value = 0
        scoreTeam2.value = 0
        team1.value = ""
        team2.value = ""
    }

    fun renameTeam1(teamName: String) {
        team1.value = teamName
    }

    fun renameTeam2(teamName: String) {
        team2.value = teamName
    }


    fun addToScore1(number: Int) {
        scoreTeam1.value = scoreTeam1.value?.plus(number)
    }

    fun substractToScre1(number: Int) {
        if (scoreTeam1.value!! > 0) {
            scoreTeam1.value = scoreTeam1.value?.minus(number)
        }
    }

    fun addToScore2(number: Int) {
        scoreTeam2.value = scoreTeam2.value?.plus(number)
    }

    fun substractToScre2(number: Int) {
        if (scoreTeam2.value!! > 0) {
            scoreTeam2.value = scoreTeam2.value?.minus(number)
        }
    }
}