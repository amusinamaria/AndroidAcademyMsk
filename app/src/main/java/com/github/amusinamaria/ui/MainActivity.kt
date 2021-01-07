package com.github.amusinamaria.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.ActivityMainBinding
import com.github.amusinamaria.repository.data.Movie
import com.github.amusinamaria.ui.details.DetailsFragment
import com.github.amusinamaria.ui.list.MoviesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, MoviesListFragment())
                commit()
            }
    }

    fun showMovieDetails(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .apply {
                setTransition(TRANSIT_FRAGMENT_FADE)
                add(R.id.fragments_container, DetailsFragment.newInstance(movie))
                addToBackStack(null)
                commit()
            }
    }
}
