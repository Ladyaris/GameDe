package com.chores.gamede.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chores.gamede.R
import com.chores.gamede.data.GameData
import com.squareup.picasso.Picasso

class ListGameAdapter(private val listGame: ArrayList<GameData>) :
    RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvGame: TextView = itemView.findViewById(R.id.tv_item_game)
        var tvProducer: TextView = itemView.findViewById(R.id.tv_studio)
        var tvRating: TextView = itemView.findViewById(R.id.tv_rating)
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_game, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val game = listGame[position]

        game.logo?.let {
            Picasso.with(holder.itemView.context)
                .load(it)
                .resize(50,50)
                .into(holder.imgPhoto)
        }

        holder.tvGame.text = game.name
        holder.tvProducer.text = game.producer
        holder.tvRating.text = game.rating
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClickedData(listGame[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listGame.size
    }

    interface OnItemClickCallback {
        fun onItemClickedData(data: GameData)
    }

}
