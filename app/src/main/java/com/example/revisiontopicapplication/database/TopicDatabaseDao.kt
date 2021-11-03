package com.example.revisiontopicapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
 interface TopicDatabaseDao {
     @Insert
     fun insert(topic:Entity)

     @Update
     fun update(topic: Entity)

     @Query("SELECT * FROM topic_table WHERE topicId = :key")
     fun get(key:String):Entity



}