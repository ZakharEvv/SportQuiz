package com.example.sportquiz.domain.usecases

import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.repository.QuizRepository

class GetCategoriesUseCase(private val quizRepository: QuizRepository) {

    fun getCategories(): List<SportCategory> {
        return quizRepository.getCategories()
    }
}