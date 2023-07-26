package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.model.User
import com.example.sportquiz.domain.usecases.GetCategoriesUseCase
import com.example.sportquiz.domain.usecases.GetLevelsUseCase
import com.example.sportquiz.domain.usecases.GetUserProgressUseCase
import com.example.sportquiz.domain.usecases.GetUserUseCase

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

    private val getCategoriesUseCase = GetCategoriesUseCase(repository)
    private val getUserProgressUseCase = GetUserProgressUseCase(repository)
    private val getUserUseCase = GetUserUseCase(repository)
    private val getLevelsUseCase = GetLevelsUseCase(repository)

    fun getCategories(): List<SportCategory> {
        return getCategoriesUseCase.getCategories()
    }

    fun getAllUserProgress(): List<Int> {
        val categories = getCategories()
        val progressList = arrayListOf<Int>()
        for (category in categories)
            progressList.add(
                getUserProgressUseCase.getUserProgress(
                    category.name,
                    getApplication()
                )
            )
        return progressList
    }

    fun getUser(): User {
        return getUserUseCase.getUser(getApplication())
    }

    fun getAllLevels(): List<Int> {
        val categories = getCategories()
        val levelsList = arrayListOf<Int>()
        for (category in categories)
            levelsList.add(
                getLevelsUseCase.getLevels(category.name).size
            )
        return levelsList
    }
}