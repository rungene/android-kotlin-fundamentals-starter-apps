package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//this class will be responsible for instantiating the ScoreViewModel object.
class ScoreViewModelFactory(private val finalScore: Int):ViewModelProvider.Factory {
    //In the create() method, return the newly constructed ScoreViewModel object.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}