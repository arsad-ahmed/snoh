package com.example.snoh.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "yes_thats_me")
data class TheProject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val code: Long=0,
    @ColumnInfo(name = "logic")
    val anything: String)
