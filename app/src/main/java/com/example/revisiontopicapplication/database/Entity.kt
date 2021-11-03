package com.example.revisiontopicapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topic_table")
data class Entity(

    @PrimaryKey(autoGenerate = true)
    var topicId:Int = 0,

    @ColumnInfo(name = "topic_name")
    var topicName:String = ""
)