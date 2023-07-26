package com.example.sportquiz.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sportquiz.R
import com.example.sportquiz.presentation.adapters.NonScrollableLinearLayoutManager
import com.example.sportquiz.presentation.adapters.ProgressAdapter
import com.example.sportquiz.presentation.viewmodels.ProfileViewModel


class ProfileFragment : Fragment() {

    private lateinit var imageProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvRank: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        initViews(view)
        setupRecyclerView(viewModel, view)
        refreshUI(viewModel, view)

        return view
    }

    private fun refreshUI(
        viewModel: ProfileViewModel,
        view: View
    ) {
        val user = viewModel.getUser()
        tvName.text = user.name
        tvRank.text = buildString {
            append(user.rank)
            append(" XP")
        }
        imageProfile.setImageDrawable(ContextCompat.getDrawable(view.context, user.avatar))
    }

    private fun setupRecyclerView(
        viewModel: ProfileViewModel,
        view: View
    ) {
        val adapter = ProgressAdapter()
        adapter.categories = viewModel.getCategories()
        adapter.progressList = viewModel.getAllUserProgress()
        adapter.levelsList = viewModel.getAllLevels()
        recyclerView.layoutManager = NonScrollableLinearLayoutManager(view.context)
        recyclerView.adapter = adapter
    }

    private fun initViews(view: View) {
        imageProfile = view.findViewById(R.id.image_profile_avatar)
        tvName = view.findViewById(R.id.tv_name_profile)
        tvRank = view.findViewById(R.id.tv_rank_profile)
        recyclerView = view.findViewById(R.id.recycler_view_profile)
    }

}