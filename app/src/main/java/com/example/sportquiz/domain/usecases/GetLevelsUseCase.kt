package com.example.sportquiz.domain.usecases

import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.repository.QuizRepository

class GetLevelsUseCase(private val quizRepository: QuizRepository) {

    fun getLevels(category: String): List<QuizLevel> {
        return quizRepository.getLevels(category)
    }
}