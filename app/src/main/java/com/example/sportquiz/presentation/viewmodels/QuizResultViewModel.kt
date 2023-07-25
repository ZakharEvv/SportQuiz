package com.example.sportquiz.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sportquiz.data.QuizRepositoryImpl

class QuizResultViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = QuizRepositoryImpl

}