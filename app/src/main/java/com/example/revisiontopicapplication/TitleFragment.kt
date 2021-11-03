package com.example.revisiontopicapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.revisiontopicapplication.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_title, container, false)

        val binding:FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        Log.i("TitleFragment","onCreateView is called.")


      /*  binding.startButton.setOnClickListener{view:View ->
            //1. to get the instance of the navigation controller
            //1. Navigation.findNavController(view)

            //2. to navigate from title to game fragment we use upper navHost instance with the action id that we are created in navigation.xml file{i.e. navigate(R.id.action_titleFragment_to_gameFragment)}
            //2. Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)

            //3. shorter version of the upper line code is like:
            //3. view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }*/

        //4. to short the entire code of click listener is like this:
        binding.startButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                TitleFragmentDirections.actionTitleFragmentToGameFragment()
            )
        )

//        binding.addBtn.setOnClickListener(
//            Navigation.createNavigateOnClickListener(
//                TitleFragmentDirections.actionTitleFragmentToInsertWord()
//            )
//        )
        return binding.root
    }



}