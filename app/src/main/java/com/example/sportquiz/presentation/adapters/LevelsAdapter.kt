package com.example.sportquiz.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sportquiz.R
import com.example.sportquiz.domain.model.QuizLevel

class LevelsAdapter : RecyclerView.Adapter<LevelsAdapter.LevelsViewHolder>() {

    var levels = listOf<QuizLevel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var progress = 0

    var onItemClickListener: ((QuizLevel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.level_item, parent, false)

        return LevelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        val level = levels[position]
        holder.tvLevel.text = buildString {
            append("Level ")
            append(level.level)
        }
        if (level.level == progress + 1) {
            setUnlockedListener(holder, level)
            holder.imageArrow.visibility = View.VISIBLE
            holder.imageLock.visibility = View.INVISIBLE
            holder.imageCompleted.visibility = View.INVISIBLE
        } else if (level.level < progress + 1) {
            setUnlockedListener(holder, level)
            holder.imageArrow.visibility = View.INVISIBLE
            holder.imageLock.visibility = View.INVISIBLE
            holder.imageCompleted.visibility = View.VISIBLE
        } else {
            setLockedListener(holder)
            holder.imageArrow.visibility = View.INVISIBLE
            holder.imageLock.visibility = View.VISIBLE
            holder.imageCompleted.visibility = View.INVISIBLE
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setUnlockedListener(
        holder: LevelsViewHolder,
        level: QuizLevel
    ) {
        holder.itemView.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    view.animate().scaleX(1f).scaleY(1f).setDuration(100).withEndAction {
                        onItemClickListener?.invoke(level)
                    }.start()
                }
            }
            true
        }
    }

    private fun setLockedListener(holder: LevelsViewHolder) {
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Complete the previous level",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return levels.size
    }

    class LevelsViewHolder(itemView: View) : ViewHolder(itemView) {
        val tvLevel = itemView.findViewById<TextView>(R.id.tv_level_item)
        val imageArrow = itemView.findViewById<ImageView>(R.id.image_arrow_level)
        val imageLock = itemView.findViewById<ImageView>(R.id.image_lock_level)
        val imageCompleted = itemView.findViewById<ImageView>(R.id.image_completed_level)
    }
}