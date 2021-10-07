package com.example.recylerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayoutTextArray = arrayOf("채팅", "북마크")
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val viewPagerAdapter = ViewPagerAdapter(this)

        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text = tabLayoutTextArray[position]
        }.attach()

    }
}