package com.example.sportquiz.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.presentation.adapters.LevelsAdapter
import com.example.sportquiz.presentation.viewmodels.LevelViewModel

class LevelFragment(sportCategory: SportCategory) : Fragment() {

    private lateinit var btnBack: LinearLayout
    private lateinit var imageCategory: ImageView
    private lateinit var tvCategory: TextView
    private lateinit var tvProgress: TextView
    private lateinit var recyclerView: RecyclerView

    private val category = sportCategory
    private var userProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_level, container, false)
        val viewModel = ViewModelProvider(this)[LevelViewModel::class.java]

        userProgress = viewModel.getUserProgress(category.name)

        initViews(view)
        refreshUI(viewModel, view)
        setupRecyclerView(viewModel)
        setupListeners()

        return view
    }

    private fun setupRecyclerView(viewModel: LevelViewModel) {
        val adapter = LevelsAdapter()
        adapter.progress = userProgress
        adapter.levels = viewModel.getLevelsUseCase(category.name)
        adapter.onItemClickListener = {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, QuizFragment(it, category))?.commit()
        }
        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, MainFragment())?.commit()
        }
    }

    private fun refreshUI(
        viewModel: LevelViewModel,
        view: View
    ) {
        val levels = viewModel.getLevelsUseCase(category.name).size
        imageCategory.setImageDrawable(ContextCompat.getDrawable(view.context, category.image))
        tvCategory.text = category.name
        tvProgress.text = "${userProgress}/$levels"
    }

    private fun initViews(view: View) {
        btnBack = view.findViewById(R.id.btn_back_levels)
        imageCategory = view.findViewById(R.id.image_category_level)
        tvCategory = view.findViewById(R.id.tv_category_name_level)
        tvProgress = view.findViewById(R.id.tv_user_progress_level)
        recyclerView = view.findViewById(R.id.recycler_view_levels)
    }


}