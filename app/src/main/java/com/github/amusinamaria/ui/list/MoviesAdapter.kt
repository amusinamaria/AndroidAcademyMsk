package com.github.amusinamaria.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.MovieCardBinding
import com.github.amusinamaria.repository.MovieCard
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class MoviesAdapter(private val clickListener: (MovieCard) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movieCards = listOf<MovieCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieCards[position])
        holder.itemView.setOnClickListener { clickListener(movieCards[position]) }
    }

    override fun getItemCount(): Int = movieCards.size

    fun bindMovieCards(newMovieCards: List<MovieCard>) {
        movieCards = newMovieCards
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val binding: MovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieCard: MovieCard) {
            val multiTransformation = MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(14, 1, RoundedCornersTransformation.CornerType.TOP)
            )

            Glide.with(itemView.context)
                .load(movieCard.pictureUrl)
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                .transition(DrawableTransitionOptions.withCrossFade(80))
                .placeholder(R.drawable.ic_movie_placeholder)
                .fallback(R.drawable.ic_movie_placeholder)
                .into(binding.moviePicture)

            binding.movieTitle.text = movieCard.title
            binding.pg.text = movieCard.pg
        }
    }
}
