package com.example.snoh.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SlideshowViewModel @Inject constructor():ViewModel()
{

    private val _text=MutableLiveData<String>().apply {
        value="This is slideshow Fragment"
    }
}