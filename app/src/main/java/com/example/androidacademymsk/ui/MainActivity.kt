package com.example.androidacademymsk.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidacademymsk.R
import com.example.androidacademymsk.ui.details.DetailsFragment
import com.example.androidacademymsk.ui.list.MoviesListFragment

class MainActivity : AppCompatActivity(), MoviesListFragment.MovieClickListener {

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

    override fun onClickShowMovieDetails() {
        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, DetailsFragment())
                addToBackStack(null)
                commit()
            }
    }
}