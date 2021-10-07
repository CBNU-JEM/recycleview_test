package com.example.recylerviewtest

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    private val pageCount = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentChat()
            1 -> FragmentBookmark()
            else -> FragmentBookmark()
        }
    }

    override fun getItemCount():Int = pageCount
}