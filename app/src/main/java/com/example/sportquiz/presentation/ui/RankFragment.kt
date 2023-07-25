package com.example.sportquiz.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sportquiz.R
import com.example.sportquiz.presentation.adapters.RankAdapter
import com.example.sportquiz.presentation.viewmodels.RankViewModel


class RankFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rank, container, false)
        val viewModel = ViewModelProvider(this)[RankViewModel::class.java]

        initViews(view)
        setupRecyclerView(viewModel)

        return view
    }

    private fun setupRecyclerView(viewModel: RankViewModel) {
        val adapter = RankAdapter()
        adapter.users = viewModel.getUsers()
        recyclerView.adapter = adapter
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view_rank)
    }

}