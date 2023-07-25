package com.example.sportquiz.domain.model

data class QuizQuestion(
    val category: String,
    val level: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int
)