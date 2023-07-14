package com.example.snoh.data.repository

import androidx.lifecycle.LiveData
import com.example.snoh.data.database.TheProjectDao
import com.example.snoh.model.TheProject
import javax.inject.Inject

class DataRepository @Inject constructor(private val projectDao:TheProjectDao)
{
    suspend fun savePasswordInDatabase(theProject:TheProject)
    {
        projectDao.savePassword(theProject)
    }

    fun getSavedPassword():LiveData<List<TheProject>>
    {
        return projectDao.getSavedPasswords()
    }
}