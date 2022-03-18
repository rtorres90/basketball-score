package com.rtorres.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private var _scoreTeam1LiveData: MutableLiveData<Int> = MutableLiveData()
    private var _scoreTeam2LiveData: MutableLiveData<Int> = MutableLiveData()

    val scoreTeam1LiveData: LiveData<Int>
        get() = _scoreTeam1LiveData

    val scoreTeam2LiveData: LiveData<Int>
        get() = _scoreTeam2LiveData

    var team1: MutableLiveData<String> = MutableLiveData()
    var team2: MutableLiveData<String> = MutableLiveData()


    init {
        _scoreTeam1LiveData.value = 0
        _scoreTeam2LiveData.value = 0
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
        _scoreTeam1LiveData.value = _scoreTeam1LiveData.value?.plus(number)
    }

    fun substractToScre1(number: Int) {
        if (_scoreTeam1LiveData.value!! > 0) {
            _scoreTeam1LiveData.value = _scoreTeam1LiveData.value?.minus(number)
        }
    }

    fun addToScore2(number: Int) {
        _scoreTeam2LiveData.value = _scoreTeam2LiveData.value?.plus(number)
    }

    fun substractToScre2(number: Int) {
        if (_scoreTeam2LiveData.value!! > 0) {
            _scoreTeam2LiveData.value = _scoreTeam2LiveData.value?.minus(number)
        }
    }
}