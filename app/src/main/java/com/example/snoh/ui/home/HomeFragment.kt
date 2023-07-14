package com.example.snoh.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.snoh.databinding.FragmentHomeBinding
import com.example.snoh.model.TheProject
import com.example.snoh.ui.adapter.HomeAdapter
import com.example.snoh.util.ALLOWED_CHARACTER
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment:Fragment()
{

    @Inject
    lateinit var homeAdapter:HomeAdapter

    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        homeViewModel.getSavedPasswords()
    }

    override fun onCreateView(inflater:LayoutInflater, container:ViewGroup?, savedInstanceState:Bundle?):View
    {

        _binding=FragmentHomeBinding.inflate(inflater, container, false)
        binding.fragment=this
        observeLiveData()
        setRecyclerView()
        return binding.root
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding=null
    }

    private fun observeLiveData()
    {
        homeViewModel.projectLiveData.observe(viewLifecycleOwner) {
            if(it.isEmpty())
            {
                binding.tvInfo.visibility=View.VISIBLE
            }
            else
            {
                binding.tvInfo.visibility=View.GONE
                homeAdapter.addPasswordInList(it)
            }
        }
    }

    private fun generateRandomString(length: Int): String
    {
        val allowedChars = ALLOWED_CHARACTER
        return (1..length)
            .map { allowedChars[Random.nextInt(allowedChars.length)] }
            .joinToString("")
    }

    fun submit()
    {
        val password=generateRandomString(10)
        homeViewModel.savedPassword(TheProject(anything = password))
    }

    private fun setRecyclerView()
    {
        binding.rvHome.adapter=homeAdapter
    }

}