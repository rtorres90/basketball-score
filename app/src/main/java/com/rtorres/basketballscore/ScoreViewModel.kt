package com.rtorres.basketballscore

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreTeam1 = 0
    var scoreTeam2 = 0
    var team1 = ""
    var team2 = ""

    fun renameTeam1(teamName: String) {
        this.team1 = teamName
    }

    fun renameTeam2(teamName: String) {
        this.team2 = teamName
    }


    fun addToScore1(number: Int) {
        this.scoreTeam1 += number
    }

    fun substractToScre1(number: Int) {
        if (scoreTeam1 > 0) {
            this.scoreTeam1 -= number
        }
    }

    fun addToScore2(number: Int) {
        this.scoreTeam2 += number
    }

    fun substractToScre2(number: Int) {
        if (scoreTeam2 > 0) {
            this.scoreTeam2 -= number
        }
    }
}