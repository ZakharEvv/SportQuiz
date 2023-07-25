package com.example.sportquiz.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.model.User

interface QuizRepository {

    fun getUserProgress(category: String, context: Context): Int

    fun saveUserProgress(category: String, progress: Int, context: Context)

    fun getLevels(category: String): List<QuizLevel>

    fun getQuestions(category: String, level: Int): List<QuizQuestion>

    fun getCategories(): List<SportCategory>

    fun getUser(context: Context): User

    fun saveUserRank(context: Context, rank: Int)

    fun getUsers(): List<User>
}