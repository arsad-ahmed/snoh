package com.example.snoh.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.snoh.BR
import com.example.snoh.R
import com.example.snoh.databinding.RvItemBinding
import com.example.snoh.model.TheProject
import javax.inject.Inject

class HomeAdapter @Inject constructor():RecyclerView.Adapter<HomeAdapter.HomeViewHolder>()
{

    private val passwordList = mutableListOf<TheProject>()

    fun addPasswordInList(list: List<TheProject>)
    {
        passwordList.clear()
        passwordList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):HomeViewHolder
    {
        return HomeViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.rv_item, parent, false))
    }

    override fun getItemCount():Int
    {
        return passwordList.size
    }

    override fun onBindViewHolder(holder:HomeViewHolder, position:Int)
    {
        holder.bind(passwordList[position])
    }

    inner class HomeViewHolder(private val binding:RvItemBinding) :RecyclerView.ViewHolder(binding.root)
    {

        fun bind(project:TheProject) = with(binding) {
            setVariable(BR.project,project)
        }
    }
}