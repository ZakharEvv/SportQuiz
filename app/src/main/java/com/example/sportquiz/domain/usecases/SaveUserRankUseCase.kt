package com.example.sportquiz.domain.usecases

import android.content.Context
import com.example.sportquiz.domain.repository.QuizRepository

class SaveUserRankUseCase(private val quizRepository: QuizRepository) {

    fun saveUserRank(context: Context, rank: Int) {
        quizRepository.saveUserRank(context, rank)
    }
}