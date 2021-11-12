package com.example.revisiontopicapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    //the current topic
    private val _topic = MutableLiveData<String>()
            val topic :LiveData<String>
            get() = _topic

    //the current score
    private val _score = MutableLiveData<Int>()
            val score :LiveData<Int>
            get() = _score


    private val _eventFinished = MutableLiveData<Boolean>()
    val eventFinished:LiveData<Boolean>
    get() = _eventFinished
    //The list of  Topic - the front of the list is the next word to guess
    private lateinit var topicList:MutableList<String>
    init {
        _eventFinished.value = false
        resetTopic()
        nextTopic()
        _score.value = 0
    }

     fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextTopic()
    }

     fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextTopic()
    }

    private fun nextTopic() {
        //select and remove a word from the list
        if(topicList.isEmpty()){
           // gameFinished()
            _eventFinished.value = true
        }
        else{
            _topic.value = topicList.removeAt(0)
        }
    }




    /**
     * This function will generate different topics
     * */
    private fun resetTopic() {
        topicList = mutableListOf(
            "Android Layouts",
            "Data Binding",
            "Navigation",
            "Git",
            "View Models"
        )
        topicList.shuffle()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel is called!!")
    }

    fun eventFinishedComplete(){
        _eventFinished.value = false
    }
}