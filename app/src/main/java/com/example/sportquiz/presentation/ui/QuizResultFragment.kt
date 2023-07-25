package com.example.sportquiz.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import com.example.sportquiz.R
import com.example.sportquiz.presentation.viewmodels.QuizResultViewModel

class QuizResultFragment(_receivedRank: Int, _correctAnswers: Int, _questions: Int) : Fragment() {

    private val receivedRank = _receivedRank
    private val correctAnswers = _correctAnswers
    private val questions = _questions

    private lateinit var tvRank: TextView
    private lateinit var tvCorrectAnswers: TextView
    private lateinit var btnExit: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_result, container, false)

        initViews(view)
        setupListeners()
        tvRank.text = "+ $receivedRank XP"
        tvCorrectAnswers.text = "$correctAnswers/$questions"

        return view
    }

    private fun setupListeners() {
        btnExit.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, MainFragment())?.commit()
        }
    }

    private fun initViews(view: View) {
        tvRank = view.findViewById(R.id.tv_rank_result)
        tvCorrectAnswers = view.findViewById(R.id.tv_correct_answers_result)
        btnExit = view.findViewById(R.id.btn_exit_result)
    }

}