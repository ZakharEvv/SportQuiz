package com.example.sportquiz.domain.usecases

import android.content.Context
import com.example.sportquiz.domain.model.User
import com.example.sportquiz.domain.repository.QuizRepository

class GetUserUseCase(private val quizRepository: QuizRepository) {

    fun getUser(context: Context): User {
        return quizRepository.getUser(context)
    }
}