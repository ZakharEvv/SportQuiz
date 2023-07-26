package com.example.sportquiz.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.example.sportquiz.R
import com.example.sportquiz.presentation.adapters.OnboardingViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager2
    private lateinit var btnStart: CardView
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        btnStart = findViewById(R.id.btn_start_onboarding)
        btnStart.setOnClickListener {
            finish()
        }

        mViewPager = findViewById(R.id.viewPager)
        mViewPager.adapter = OnboardingViewPagerAdapter(this)
        tabLayout = findViewById(R.id.pageIndicator)
        TabLayoutMediator(tabLayout, mViewPager) { _, _ -> }.attach()
        mViewPager.offscreenPageLimit = 1
    }
}