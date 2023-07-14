package com.example.snoh.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snoh.data.repository.DataRepository
import com.example.snoh.model.TheProject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepository:DataRepository) : ViewModel()
{

    private lateinit var _projectLiveData:LiveData<List<TheProject>>
    val projectLiveData get() = _projectLiveData

    fun savedPassword(theProject:TheProject)
    {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.savePasswordInDatabase(theProject)
        }
    }

    fun getSavedPasswords()
    {
        viewModelScope.launch (Dispatchers.IO){
            _projectLiveData=dataRepository.getSavedPassword()
        }
    }
}