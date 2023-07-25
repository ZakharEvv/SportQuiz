package com.example.sportquiz.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.presentation.ui.RankFragment

class SportCategoriesAdapter :
    RecyclerView.Adapter<SportCategoriesAdapter.SportCategoriesViewHolder>() {

    var categories = listOf<SportCategory>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClickListener: ((SportCategory) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportCategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sport_item, parent, false)

        return SportCategoriesViewHolder(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: SportCategoriesViewHolder, position: Int) {
        val category = categories[position]
        holder.imageCategory.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context,
                category.image
            )
        )
        holder.tvCategory.text = category.name
        val scaleAnim = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.button_scale)
        holder.itemView.setOnClickListener {
            it.startAnimation(scaleAnim)
            onItemClickListener?.invoke(category)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(category: SportCategory)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class SportCategoriesViewHolder(itemView: View) : ViewHolder(itemView) {
        val imageCategory = itemView.findViewById<ImageView>(R.id.image_category_main)
        val tvCategory = itemView.findViewById<TextView>(R.id.tv_category_name_main)
    }
}