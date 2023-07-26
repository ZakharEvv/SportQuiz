package com.example.sportquiz.presentation.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.SportCategory

class ProgressAdapter : RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder>() {

    var categories = listOf<SportCategory>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var progressList = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var levelsList = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_progress_item, parent, false)

        return ProgressViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, position: Int) {
        val category = categories[position]
        val progress = progressList[position]
        val levels = levelsList[position]

        holder.imageCategory.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context,
                category.image
            )
        )
        holder.tvCategory.text = category.name
        holder.tvProgress.text = buildString {
            append(progress)
            append("/")
            append(levels)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class ProgressViewHolder(itemView: View) : ViewHolder(itemView) {
        val imageCategory = itemView.findViewById<ImageView>(R.id.image_category_progress_item)
        val tvCategory = itemView.findViewById<TextView>(R.id.tv_category_name_progress_item)
        val tvProgress = itemView.findViewById<TextView>(R.id.tv_user_progress_progress_item)
    }
}