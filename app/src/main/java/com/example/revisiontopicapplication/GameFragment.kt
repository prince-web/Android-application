package com.example.revisiontopicapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.revisiontopicapplication.databinding.FragmentGameBinding


class GameFragment : Fragment() {


    private lateinit var viewModel: GameViewModel

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )


        // viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.topic.observe(viewLifecycleOwner, Observer { newTopic ->
            binding.topicText.text = newTopic.toString()
        })

        viewModel.eventFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                gameFinished()
                viewModel.eventFinishedComplete()
            }
        })


        return binding.root
    }


    private fun gameFinished() {

        Toast.makeText(this.activity, "Game has Finished", Toast.LENGTH_LONG).show()
        val action =
            GameFragmentDirections.actionGameFragmentToScoreFragment(viewModel.score.value ?: 0)
        val currentScore = viewModel.score.value ?: 0
        action.score = currentScore
        this.findNavController().navigate(action)
        //Navigation.createNavigateOnClickListener(GameFragmentDirections.actionGameFragmentToScoreFragment(score))
    }


}