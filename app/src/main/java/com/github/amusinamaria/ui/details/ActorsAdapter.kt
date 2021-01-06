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
import com.github.amusinamaria.databinding.ActorCardBinding
import com.github.amusinamaria.repository.data.Actor
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class ActorsAdapter : RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>() {

    private var actors = listOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder =
        ActorViewHolder(
            ActorCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int = actors.size

    fun bindActorsCards(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }

    class ActorViewHolder(private val binding: ActorCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(actor: Actor) {
            val multiTransformation = MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(4, 0)
            )

            Glide.with(itemView.context)
                .load(actor.profilePicture)
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.ic_cast_placeholder)
                .fallback(R.drawable.ic_cast_placeholder)
                .into(binding.actorPhoto)

            binding.actorName.text = actor.name
        }
    }
}
