package com.example.sideappfordemoofjsonparsing.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sideappfordemoofjsonparsing.R
import com.example.sideappfordemoofjsonparsing.data.Monster

class MonsterGridAdapter(private val context: Context, private val monster: List<Monster>,val listener:MonsterItemListener) :
    RecyclerView.Adapter<MonsterGridAdapter.viewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MonsterGridAdapter.viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.monster_grid_item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return monster.size
    }

    override fun onBindViewHolder(holder: MonsterGridAdapter.viewHolder, position: Int) {
        val monster = monster[position]

        holder.name.text = monster.monsterName
        holder.ratingBar.rating = monster.scariness.toFloat()

        holder.itemView.setOnClickListener {
            listener.onMonsterItemClickListener(monster)
        }
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.nameText)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
    }

    interface MonsterItemListener {
        fun onMonsterItemClickListener(monster: Monster)
    }
}