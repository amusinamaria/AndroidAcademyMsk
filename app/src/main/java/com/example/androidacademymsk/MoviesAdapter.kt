package com.example.androidacademymsk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.zhanghai.android.materialratingbar.MaterialRatingBar

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movieCards = listOf<MovieCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setData(movieCards[position])
    }

    override fun getItemCount(): Int = movieCards.size

    fun bindMovieCards(newMovieCards: List<MovieCard>) {
        movieCards = newMovieCards
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView? = itemView.findViewById(R.id.movieTitle)
        private val picture: ImageView? = itemView.findViewById(R.id.moviePicture)
        private val ratingBar: MaterialRatingBar? = itemView.findViewById(R.id.movieRatingBar)
        private val pg: TextView? = itemView.findViewById(R.id.pg)

        fun setData(movieCard: MovieCard) {
            Glide.with(itemView.context)
                .load(R.drawable.mock_picture_movie)
                .into(picture)

            title?.text = movieCard.title
            ratingBar?.rating = movieCard.rating.toFloat()
            pg?.text = movieCard.pg
        }
    }
}