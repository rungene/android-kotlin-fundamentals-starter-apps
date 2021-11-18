package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    //to illustrate Viewmodel is lifecycle aware
    init {
        Log.i("GameViewModel","GameViewModel created")
    }


    override fun onCleared() {
        super.onCleared()

        Log.i("GameViewModel","GameViewModel is destroyed ")
    }
}