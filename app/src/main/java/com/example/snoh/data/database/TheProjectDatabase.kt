package com.example.snoh.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.snoh.data.database.TheProjectDao
import com.example.snoh.model.TheProject


@Database(entities = [TheProject::class], version = 1)
abstract class TheProjectDatabase:RoomDatabase()
{
    abstract fun getDao():TheProjectDao
}