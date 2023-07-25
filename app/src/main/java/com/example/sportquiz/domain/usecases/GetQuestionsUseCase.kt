package com.example.sportquiz.domain.usecases

import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.repository.QuizRepository

class GetQuestionsUseCase(private val quizRepository: QuizRepository) {

    fun getQuestions(category: String, level: Int): List<QuizQuestion> {
        return quizRepository.getQuestions(category, level)
    }
}