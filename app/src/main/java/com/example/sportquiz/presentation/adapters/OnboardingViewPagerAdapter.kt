package com.example.sportquiz.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportquiz.R
import com.example.sportquiz.presentation.ui.OnboardingFragment

class OnboardingViewPagerAdapter(
    fragmentActivity: FragmentActivity
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(
                "Welcome to Sports quizzes!",
                "Immerse yourself in the exciting world of sports! Choose your favorite sports category and complete the quiz levels!",
                R.drawable.wellcome_icon_onboarding
            )
            1 -> OnboardingFragment.newInstance(
                "Try different categories",
                "We have many categories of sports: football, basketball, hockey and much more! Choose your path and prove that you are a true sports expert.",
                R.drawable.sport_types_onboarding
            )
            else -> OnboardingFragment.newInstance(
                "Reward for your skill",
                "Win quizzes, earn experience and take leading positions in the rating table! Show everyone that you are a real champion and become the king of sports quizzes!",
                R.drawable.leaderboard_icon_onboarding
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}