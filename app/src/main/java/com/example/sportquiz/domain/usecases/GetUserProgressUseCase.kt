package com.example.sportquiz.domain.usecases

import android.content.Context
import com.example.sportquiz.domain.repository.QuizRepository

class GetUserProgressUseCase(private val quizRepository: QuizRepository) {

    fun getUserProgress(category: String, context: Context): Int {
        return quizRepository.getUserProgress(category, context)
    }
}