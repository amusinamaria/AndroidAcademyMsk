package com.example.androidacademymsk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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
        private val title: TextView? = itemView.findViewById(R.id.movie_title)
        private val picture: ImageView? = itemView.findViewById(R.id.movie_picture)

        fun setData(movieCard: MovieCard) {
            Glide.with(itemView.context)
                .load(R.drawable.mock_picture_movie)
                .into(picture)

            title?.text = movieCard.title
        }
    }
}