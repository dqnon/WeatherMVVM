package com.example.weathermvvm.presentation.adapters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.weathermvvm.domain.model.searchCity.SearchCityItem
import com.example.weathermvvm.presentation.screens.ARG_CITY
import com.example.weathermvvm.presentation.screens.MainFragment

class VpAdapter(fa: FragmentActivity,  private val list: MutableList<String>): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].hashCode().toLong()
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = MainFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_CITY, list[position])
        }
        return fragment
    }

    fun addCity(cityItem: SearchCityItem) {
        list.add(cityItem.name)
        notifyDataSetChanged()
    }

    fun deleteCity(position: Int){
        Log.d("PosLog", "$list")
        Log.d("PosLog", "$position")
        list.removeAt(position)
        notifyDataSetChanged()
    }



}