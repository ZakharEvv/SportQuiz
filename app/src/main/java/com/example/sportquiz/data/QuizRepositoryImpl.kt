package com.example.sportquiz.data

import android.content.Context
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.model.User
import com.example.sportquiz.domain.repository.QuizRepository

object QuizRepositoryImpl : QuizRepository {

    private val sportCategories = Database.sportCategories
    private val quizLevels = Database.quizLevels
    private val quizQuestions = Database.quizQuestions
    private val users = Database.users

    private const val PREFERENCES = "quiz_preferences"

    override fun getUserProgress(category: String, context: Context): Int {
        val sharedPrefs = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        return sharedPrefs.getInt(category, 0)
    }

    override fun saveUserProgress(category: String, progress: Int, context: Context) {
        val sharedPrefs = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putInt(category, progress)
        editor.apply()
    }

    override fun getLevels(category: String): List<QuizLevel> {
        return quizLevels.filter { it.sportCategory == category }
    }

    override fun getQuestions(category: String, level: Int): List<QuizQuestion> {
        return quizQuestions.filter { it.category == category && it.level == level }
    }

    override fun getCategories(): List<SportCategory> {
        return sportCategories
    }

    override fun getUser(context: Context): User {
        val sharedPrefs = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val rank = sharedPrefs.getInt("user_rank", 0)
        return User("user123", R.drawable.user_icon_default, rank)
    }

    override fun saveUserRank(context: Context, rank: Int) {
        val sharedPrefs = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val savedRank = sharedPrefs.getInt("user_rank", 0)
        val editor = sharedPrefs.edit()
        editor.putInt("user_rank", rank + savedRank)
        editor.apply()
    }

    override fun getUsers(): List<User> {
        return users
    }
}