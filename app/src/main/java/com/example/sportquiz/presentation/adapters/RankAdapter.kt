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
import com.example.sportquiz.domain.model.User

class RankAdapter : RecyclerView.Adapter<RankAdapter.RankViewHolder>() {

    var users = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val medals = listOf(
        R.drawable.first_place_icon,
        R.drawable.second_place_icon,
        R.drawable.third_place_icon
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)

        return RankViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val user = users[position]

        if (position <= 2) {
            holder.tvPlace.visibility = View.GONE
            holder.imagePlace.visibility = View.VISIBLE
            holder.imagePlace.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    medals[position]
                )
            )
        } else {
            holder.tvPlace.visibility = View.VISIBLE
            holder.imagePlace.visibility = View.GONE
            holder.tvPlace.text = (position + 1).toString()
        }

        holder.tvName.text = user.name
        holder.tvRank.text = "${user.rank} XP"
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class RankViewHolder(itemView: View) : ViewHolder(itemView) {
        val imagePlace = itemView.findViewById<ImageView>(R.id.image_leaderboard_place)
        val imageAvatar = itemView.findViewById<ImageView>(R.id.image_leaderboard_avatar)
        val tvPlace = itemView.findViewById<TextView>(R.id.tv_leaderboard_place)
        val tvName = itemView.findViewById<TextView>(R.id.tv_leaderboard_name)
        val tvRank = itemView.findViewById<TextView>(R.id.tv_leaderboard_rank)
    }
}