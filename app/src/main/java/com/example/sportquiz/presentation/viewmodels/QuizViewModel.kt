package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl
import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.usecases.GetQuestionsUseCase
import com.example.sportquiz.domain.usecases.GetUserProgressUseCase
import com.example.sportquiz.domain.usecases.SaveUserProgressUseCase
import com.example.sportquiz.domain.usecases.SaveUserRankUseCase

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

    private val getQuestionsUseCase = GetQuestionsUseCase(repository)
    private val getUserProgressUseCase = GetUserProgressUseCase(repository)
    private val saveUserRankUseCase = SaveUserRankUseCase(repository)
    private val saveUserProgressUseCase = SaveUserProgressUseCase(repository)

    fun getQuestions(category: String, level: Int): List<QuizQuestion> {
        return getQuestionsUseCase.getQuestions(category, level)
    }

    fun getUserProgress(category: String): Int {
        return getUserProgressUseCase.getUserProgress(category, getApplication())
    }

    fun saveUserRank(rank: Int) {
        saveUserRankUseCase.saveUserRank(getApplication(), rank)
    }

    fun saveUserProgress(category: String, progress: Int) {
        saveUserProgressUseCase.saveUserProgress(category, progress, getApplication())
    }
}