package com.example.projetoestudo1.feature.presentation.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoestudo1.R
import com.example.projetoestudo1.databinding.ItemGameBinding
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse

class GamesAdapter(
    private val context: Context,
    private val games: MutableList<GamesResponse> = mutableListOf()
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesAdapter.GamesViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemGameBinding.inflate(inflater, parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesAdapter.GamesViewHolder, position: Int) {
        val games = games[position]
        holder.gamesTitle.text = games.title
    }

    override fun getItemCount(): Int = games.size

    fun append(games: List<GamesResponse>){
        this.games.clear()
        this.games.addAll(games)
        notifyDataSetChanged()
    }

    inner class GamesViewHolder(binding: ItemGameBinding): RecyclerView.ViewHolder(binding.root){
        val gamesTitle: TextView = itemView.findViewById(R.id.tv_name_game)
    }

}
