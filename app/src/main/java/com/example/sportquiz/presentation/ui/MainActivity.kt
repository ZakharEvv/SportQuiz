package com.example.sportquiz.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportquiz.R
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar
import github.com.st235.lib_expandablebottombar.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var bottomBar: ExpandableBottomBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupListeners()
        loadFragment(MainFragment())
        showOnboarding()
    }

    private fun showOnboarding() {
        val sharedPrefs = getSharedPreferences("quiz_preferences", MODE_PRIVATE)
        val isShowed = sharedPrefs.getBoolean("is_onboarding_showed", false)
        if (!isShowed) {
            val intent = Intent(applicationContext, OnboardingActivity::class.java)
            startActivity(intent)
            val editor = sharedPrefs.edit()
            editor.putBoolean("is_onboarding_showed", true)
            editor.apply()
        }
    }

    private fun initViews() {
        bottomBar = findViewById(R.id.expandable_bottom_bar)
    }

    private fun setupListeners() {
        bottomBar.onItemSelectedListener = { _: View, menuItem: MenuItem, b: Boolean ->
            when (menuItem.id) {
                R.id.menu_main -> loadFragment(MainFragment())
                R.id.menu_rank -> loadFragment(RankFragment())
                R.id.menu_profile -> loadFragment(ProfileFragment())
            }
        }

        bottomBar.onItemReselectedListener = { _: View, menuItem: MenuItem, b: Boolean ->
            when (menuItem.id) {
                R.id.menu_main -> loadFragment(MainFragment())
                R.id.menu_rank -> loadFragment(RankFragment())
                R.id.menu_profile -> loadFragment(ProfileFragment())
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}