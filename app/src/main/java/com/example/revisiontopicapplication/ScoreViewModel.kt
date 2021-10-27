package com.example.revisiontopicapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs

class ScoreViewModel:ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score :LiveData<Int>
    get() = _score
    init {


    }
}