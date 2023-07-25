package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.usecases.GetCategoriesUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

    private val getCategoriesUseCase = GetCategoriesUseCase(repository)

    fun getCategories(): List<SportCategory> {
        return getCategoriesUseCase.getCategories()
    }
}