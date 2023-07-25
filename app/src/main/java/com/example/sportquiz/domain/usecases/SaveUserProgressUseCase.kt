package com.example.sportquiz.domain.usecases

import android.content.Context
import com.example.sportquiz.domain.repository.QuizRepository

class SaveUserProgressUseCase(private val quizRepository: QuizRepository) {

    fun saveUserProgress(category: String, progress: Int, context: Context) {
        quizRepository.saveUserProgress(category, progress, context)
    }
}