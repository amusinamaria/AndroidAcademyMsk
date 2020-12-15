package com.github.amusinamaria.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.github.amusinamaria.R
import com.github.amusinamaria.repository.MovieCard
import com.github.amusinamaria.ui.details.DetailsFragment
import com.github.amusinamaria.ui.list.MoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, MoviesListFragment())
                    commit()
                }
        }
    }

    fun showMovieDetails(movieCard: MovieCard) {
        val detailsFragment = DetailsFragment()
        val args = Bundle()
        args.putParcelable(MOVIE_ARGS_KEY, movieCard)
        detailsFragment.arguments = args

        supportFragmentManager.beginTransaction()
            .setTransition(TRANSIT_FRAGMENT_FADE)
            .apply {
                add(R.id.fragments_container, detailsFragment)
                addToBackStack(null)
                commit()
            }
    }

    companion object {
        const val MOVIE_ARGS_KEY = "movie"
    }
}