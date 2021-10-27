package com.example.revisiontopicapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.revisiontopicapplication.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {


private lateinit var binding:FragmentScoreBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score,container,false)
//
//         Toast.makeText(context,"Your Score is: ${args.score}",Toast.LENGTH_LONG).show()

        //Get the args using by navArgs property delegate
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()
        binding.scoreTv.text =scoreFragmentArgs.score.toString()
//        binding.playAgainButton.set
        return binding.root
    }


}