package com.example.advancedwealthtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
import com.example.advancedwealthtrackerapp.R

class MainActivity : AppCompatActivity() {

    private val studentSurname = "Khizanashvili"   // starts with 'K' (consonant)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gk_li_activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.gk_li_viewPager)
        val tabLayout: com.google.android.material.tabs.TabLayout = findViewById(R.id.gk_li_tabLayout)

        val adapter = WealthPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Input"
                1 -> tab.text = "Analytics"
                2 -> tab.text = "Profile"
            }
        }.attach()

        val firstChar = studentSurname.first().uppercaseChar()
        if (isConsonant(firstChar)) {
            viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        } else {
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    private fun isConsonant(ch: Char): Boolean {
        return ch !in setOf('A', 'E', 'I', 'O', 'U')
    }
}