package com.example.sportquiz.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.sportquiz.R

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
        refreshUI()

        return view
    }

    private fun refreshUI() {
        tvRank.text = buildString {
            append("+ ")
            append(receivedRank)
            append(" XP")
        }
        tvCorrectAnswers.text = buildString {
            append(correctAnswers)
            append("/")
            append(questions)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupListeners() {
        btnExit.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    view.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.fragment_container, MainFragment())?.commit()
                    }.start()
                }
            }
            true
        }
    }

    private fun initViews(view: View) {
        tvRank = view.findViewById(R.id.tv_rank_result)
        tvCorrectAnswers = view.findViewById(R.id.tv_correct_answers_result)
        btnExit = view.findViewById(R.id.btn_exit_result)
    }

}