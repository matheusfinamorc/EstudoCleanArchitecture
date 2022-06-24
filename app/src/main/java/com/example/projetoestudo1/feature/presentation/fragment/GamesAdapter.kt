package com.example.projetoestudo1.feature.presentation.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetoestudo1.R
import com.example.projetoestudo1.databinding.ItemGameBinding
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse

class GamesAdapter(
    private val context: Context,
    private val games: MutableList<GamesResponse> = mutableListOf()
) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamesAdapter.GamesViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemGameBinding.inflate(inflater, parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesAdapter.GamesViewHolder, position: Int) {
        holder.bindingData(games[position])
        expandableItem(position, holder)

    }

    private fun expandableItem(
        position: Int,
        holder: GamesViewHolder
    ) {
        val isExpandable: Boolean = games[position].expandable
        if(isExpandable){
            holder.expandableLayout.visibility = VISIBLE
        }else holder.expandableLayout.visibility = GONE

        holder.button.setOnClickListener {
            val games = games[position]
            games.expandable = !games.expandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = games.size

    fun append(games: List<GamesResponse>) {
        this.games.clear()
        this.games.addAll(games)
        notifyDataSetChanged()
    }

    inner class GamesViewHolder(binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val gamesTitle: TextView = itemView.findViewById(R.id.tv_name_game)

        private val gamesDescription: TextView = itemView.findViewById(R.id.tv_game_description)

        private val gamesPlatform: TextView = itemView.findViewById(R.id.tv_game_platform)

        private val image: ImageView = itemView.findViewById(R.id.view_list_game)

        var button: ImageButton = itemView.findViewById(R.id.expand_button_more)

        var expandableLayout: RelativeLayout = itemView.findViewById(R.id.expandable_layout)

        fun bindingData(gamesItem: GamesResponse) {
            gamesTitle.text = gamesItem.title
            gamesDescription.text = gamesItem.short_description
            gamesPlatform.text = gamesItem.platform

            Glide.with(itemView)
                .load(gamesItem.thumbnail)
                .centerCrop()
                .into(image)
        }

    }

}
