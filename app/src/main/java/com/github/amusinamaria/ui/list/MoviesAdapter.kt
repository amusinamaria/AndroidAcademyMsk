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
import com.github.amusinamaria.repository.data.Movie
import com.github.amusinamaria.toImageUrl
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class MoviesAdapter(private val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener { clickListener(movies[position]) }
    }

    override fun getItemCount(): Int = movies.size

    fun bindMovieCards(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val binding: MovieCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            val multiTransformation = MultiTransformation(
                CenterCrop(),
                RoundedCornersTransformation(14, 1, RoundedCornersTransformation.CornerType.TOP)
            )

            Glide.with(itemView.context)
                .load(movie.poster.toImageUrl())
                .apply(RequestOptions.bitmapTransform(multiTransformation))
                .transition(DrawableTransitionOptions.withCrossFade(80))
                .placeholder(R.drawable.ic_movie_placeholder)
                .fallback(R.drawable.ic_movie_placeholder)
                .into(binding.moviePicture)

            binding.apply {
                movieTitle.text = movie.title
                pg.text = itemView.context.getString(R.string.pg, movie.minimumAge)
                movieRatingBar.rating = movie.rating / 2
                movieReviews.text = itemView.context.resources.getQuantityString(
                    R.plurals.reviews,
                    movie.numberOfReviews,
                    movie.numberOfReviews
                )
                movieTags.text = movie.genres.joinToString { it.name }
            }
        }
    }
}
