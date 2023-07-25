package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl
import com.example.sportquiz.domain.model.User
import com.example.sportquiz.domain.usecases.GetUserUseCase
import com.example.sportquiz.domain.usecases.GetUsersUseCase

class RankViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

    private val getUsersUseCase = GetUsersUseCase(repository)
    private val getUserUseCase = GetUserUseCase(repository)

    fun getUsers(): List<User> {
        val users = getUsersUseCase.getUsers()
        val usersList = ArrayList(users)
        usersList.add(getUser())
        return usersList.sortedByDescending { it.rank }
    }

    fun getUser(): User {
        return getUserUseCase.getUser(getApplication())
    }
}