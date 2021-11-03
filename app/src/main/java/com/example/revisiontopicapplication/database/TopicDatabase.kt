package com.example.revisiontopicapplication.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class TopicDatabase:RoomDatabase() {
    //Declare am abstract value of type TopicDatabaseDao
    abstract val topicDatabaseDao:TopicDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE:TopicDatabase?= null

        fun getInstance(context: Context) :TopicDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TopicDatabase::class.java,
                        "Topic_histort_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}