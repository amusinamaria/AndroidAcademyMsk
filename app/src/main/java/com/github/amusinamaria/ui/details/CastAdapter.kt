package com.github.amusinamaria.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.CastCardBinding
import com.github.amusinamaria.repository.CastCard
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private var castCards = listOf<CastCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder =
        CastViewHolder(
            CastCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(castCards[position])
    }

    override fun getItemCount(): Int = castCards.size

    fun bindCastCards(newCastCards: List<CastCard>) {
        castCards = newCastCards
        notifyDataSetChanged()
    }

    class CastViewHolder(private val binding: CastCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(castCard: CastCard) {
            val multiTransformation = MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(4, 0)
            )

            Glide.with(itemView.context)
                .load(castCard.url)
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.ic_cast_placeholder)
                .fallback(R.drawable.ic_cast_placeholder)
                .into(binding.castPhoto)

            binding.castName.text = castCard.name
        }
    }
}
