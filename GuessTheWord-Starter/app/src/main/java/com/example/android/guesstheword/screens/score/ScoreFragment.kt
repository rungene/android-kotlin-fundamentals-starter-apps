/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.ScoreFragmentBinding
import com.example.android.guesstheword.screens.game.GameFragmentDirections

/**
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.score_fragment,
                container,
                false
        )
  // initialize the viewModelFactory. Use the ScoreViewModelFactory.
        // Pass in the final score from the argument bundle, as a constructor parameter
        // to the ScoreViewModelFactory().
        viewModelFactory= ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)

 // initialize the viewModel object. Call the ViewModelProvider.get() method, pass in the
        // associated score fragment context and viewModelFactory. This will create the
        // ScoreViewModel object using the factory method defined in the viewModelFactory class.

        viewModel = ViewModelProvider(this,viewModelFactory)[ScoreViewModel::class.java]

   //set the text of the scoreText view to the final score defined in the ScoreViewModel
   binding.scoreText.text=viewModel.score.toString()
        binding.playAgainButton.visibility=View.VISIBLE
        binding.playAgainButton.setOnClickListener { replayGame() }


        return binding.root
    }

    private fun replayGame(){

        val action = ScoreFragmentDirections.actionRestart()
        NavHostFragment.findNavController(this).navigate(action)
    }
}
