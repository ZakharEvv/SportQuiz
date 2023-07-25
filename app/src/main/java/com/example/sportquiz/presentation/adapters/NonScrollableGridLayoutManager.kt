package com.example.sportquiz.presentation.adapters

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class NonScrollableGridLayoutManager(context: Context) : GridLayoutManager(context, 2) {
    override fun canScrollVertically(): Boolean {
        return false
    }
}