package com.example.androidacademymsk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var castCards = listOf<CastCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cast_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.setData(castCards[position])
    }

    override fun getItemCount(): Int = castCards.size

    fun bindCastCards(newCastCards: List<CastCard>) {
        castCards = newCastCards
        notifyDataSetChanged()
    }

    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView? = itemView.findViewById(R.id.castName)
        private val picture: ImageView? = itemView.findViewById(R.id.castPhoto)

        fun setData(castCard: CastCard) {
            Glide.with(itemView.context)
                .load(R.drawable.mock_picture_bieber)
                .into(picture)

            name?.text = castCard.name
        }
    }
}