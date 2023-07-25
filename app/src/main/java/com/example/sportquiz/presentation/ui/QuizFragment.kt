package com.example.sportquiz.presentation.ui

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.animation.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.presentation.viewmodels.QuizViewModel


class QuizFragment(quizLevel: QuizLevel) : Fragment() {

    private lateinit var btnFirst: LinearLayout
    private lateinit var btnSecond: LinearLayout
    private lateinit var btnThird: LinearLayout
    private lateinit var tvQuestionNumber: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCategory: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var imageCategory: ImageView
    private lateinit var tvFirstAnswer: TextView
    private lateinit var tvSecondAnswer: TextView
    private lateinit var tvThirdAnswer: TextView

    private val quizLevel = quizLevel.level
    private val quizCategory = quizLevel.sportCategory
    private var questions = listOf<QuizQuestion>()

    private lateinit var viewModel: QuizViewModel

    private var actualQuestion = 0
    private var correctAnswers = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)
        viewModel = ViewModelProvider(this)[QuizViewModel::class.java]
        questions = viewModel.getQuestions(quizCategory, quizLevel)
        initViews(view)
        tvLevel.text = quizLevel.toString()
        tvCategory.text = quizCategory

        refreshQuestion()

        setupListeners(view)

        return view
    }

    private fun refreshQuestion() {
        if (questions.lastIndex < actualQuestion) {
            if (correctAnswers==questions.size){
                if (viewModel.getUserProgress(quizCategory) == quizLevel)
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragment_container, QuizResultFragment(0, correctAnswers, questions.size))?.commit()
                else {
                    viewModel.saveUserProgress(quizCategory, quizLevel)
                    viewModel.saveUserRank(quizLevel * 100)
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragment_container, QuizResultFragment(quizLevel*100, correctAnswers, questions.size))?.commit()
                }
            } else {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, QuizResultFragment(0, correctAnswers, questions.size))?.commit()
            }
        } else {
            tvQuestionNumber.text = "${actualQuestion + 1}/${questions.size}"
            tvQuestion.text = questions[actualQuestion].question
            tvFirstAnswer.text = questions[actualQuestion].answers[0]
            tvSecondAnswer.text = questions[actualQuestion].answers[1]
            tvThirdAnswer.text = questions[actualQuestion].answers[2]
        }
    }


    private fun setupListeners(view: View) {
        btnFirst.setOnClickListener {
            checkAnswer(btnFirst, view, 0)
        }
        btnSecond.setOnClickListener {
            checkAnswer(btnSecond, view, 1)
        }
        btnThird.setOnClickListener {
            checkAnswer(btnThird, view, 2)
        }
    }

    private fun checkAnswer(btn: LinearLayout, view: View, answer: Int) {
        if (questions[actualQuestion].correctAnswer == answer) {
            startAnimation(btn, view, R.color.green_light)
            correctAnswers++
        } else
            startAnimation(btn, view, R.color.red_light)
        actualQuestion++
    }

    private fun initViews(view: View) {
        btnFirst = view.findViewById(R.id.btn_first_answer_quiz)
        btnSecond = view.findViewById(R.id.btn_second_answer_quiz)
        btnThird = view.findViewById(R.id.btn_third_answer_quiz)
        tvQuestionNumber = view.findViewById(R.id.tv_question_number_quiz)
        tvQuestion = view.findViewById(R.id.tv_question_quiz)
        tvLevel = view.findViewById(R.id.tv_level_quiz)
        tvCategory = view.findViewById(R.id.tv_header_quiz)
        imageCategory = view.findViewById(R.id.image_view_sport_quiz)
        tvFirstAnswer = view.findViewById(R.id.tv_first_answer)
        tvSecondAnswer = view.findViewById(R.id.tv_second_answer)
        tvThirdAnswer = view.findViewById(R.id.tv_third_answer)
    }

    private fun setEnabled(value: Boolean) {
        btnFirst.isEnabled = value
        btnSecond.isEnabled = value
        btnThird.isEnabled = value
    }

    private fun startAnimation(btn: LinearLayout, view: View, color: Int) {
        setEnabled(false)
        val colorAnimator = ObjectAnimator.ofArgb(
            btn,
            "backgroundColor",
            ContextCompat.getColor(view.context, R.color.grey),
            ContextCompat.getColor(view.context, color)
        )
        colorAnimator.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(createDelayAnimator(0), colorAnimator)
        animatorSet.start()
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                setEnabled(true)
                refreshQuestion()
                btn.setBackgroundColor(ContextCompat.getColor(btn.context, R.color.grey))
            }
        })
    }

    private fun createDelayAnimator(duration: Long): ObjectAnimator {
        return ObjectAnimator.ofFloat(Any(), "alpha", 0f, 0f).apply {
            this.duration = duration
        }
    }

}