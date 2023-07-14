package com.example.snoh.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.snoh.model.TheProject

@Dao
interface TheProjectDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePassword(projectModel:TheProject)

    @Query("SELECT * FROM yes_thats_me")
    fun getSavedPasswords():LiveData<List<TheProject>>
}