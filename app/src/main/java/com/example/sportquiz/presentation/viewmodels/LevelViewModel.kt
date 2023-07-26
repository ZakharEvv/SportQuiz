package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl
import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.usecases.GetLevelsUseCase
import com.example.sportquiz.domain.usecases.GetUserProgressUseCase

class LevelViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

    private val getUserProgressUseCase = GetUserProgressUseCase(repository)
    private val getLevelsUseCase = GetLevelsUseCase(repository)

    fun getUserProgress(category: String): Int {
        return getUserProgressUseCase.getUserProgress(category, getApplication())
    }

    fun getLevelsUseCase(category: String): List<QuizLevel> {
        return getLevelsUseCase.getLevels(category)
    }
}