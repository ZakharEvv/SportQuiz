package com.example.sportquiz.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sportquiz.R
import com.example.sportquiz.presentation.adapters.NonScrollableGridLayoutManager
import com.example.sportquiz.presentation.adapters.SportCategoriesAdapter
import com.example.sportquiz.presentation.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private lateinit var btnRules: CardView
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initViews(view)
        setupRecyclerView(viewModel, view)
        setupListeners()

        return view
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupListeners() {
        btnRules.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    view.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                        val dialogFragment = RulesDialogFragment()
                        activity?.supportFragmentManager?.let {
                            dialogFragment.show(
                                it,
                                "CustomDialogFragment"
                            )
                        }
                    }.start()
                }
            }
            true
        }
    }

    private fun setupRecyclerView(viewModel: MainViewModel, view: View) {
        val adapter = SportCategoriesAdapter()
        adapter.categories = viewModel.getCategories()

        adapter.onItemClickListener = {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, LevelFragment(it))?.commit()
        }
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = NonScrollableGridLayoutManager(view.context)
    }

    private fun initViews(view: View) {
        btnRules = view.findViewById(R.id.btn_rules)
        recyclerView = view.findViewById(R.id.recycler_view_categories)
    }
}