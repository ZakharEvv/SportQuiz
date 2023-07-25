package com.example.sportquiz.domain.usecases

import com.example.sportquiz.domain.model.User
import com.example.sportquiz.domain.repository.QuizRepository

class GetUsersUseCase(private val quizRepository: QuizRepository) {

    fun getUsers(): List<User> {
        return quizRepository.getUsers()
    }
}