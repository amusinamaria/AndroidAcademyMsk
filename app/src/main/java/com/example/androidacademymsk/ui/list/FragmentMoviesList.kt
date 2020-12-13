package com.example.androidacademymsk.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidacademymsk.R
import com.example.androidacademymsk.repository.MockDataSource


class FragmentMoviesList : Fragment() {

    private var listener: MovieClickListener? = null
    private lateinit var moviesRecycler: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.goToDetailButton).apply {
            setOnClickListener {
                listener?.onClickShowMovieDetails()
            }
        }
        moviesRecycler = view.findViewById(R.id.movies_recycler)
        val columnsCount: Int = resources.getInteger(R.integer.movie_cards_column_count)
        moviesRecycler.apply {
            layoutManager = GridLayoutManager(context, columnsCount)
            addItemDecoration(MovieCardsSpacingDecoration(columnsCount))
        }
        moviesAdapter = MoviesAdapter()
        moviesRecycler.adapter = moviesAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClickListener) {
            listener = context
        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        moviesAdapter.apply {
            bindMovieCards(MockDataSource().getMovieCards())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface MovieClickListener {
        fun onClickShowMovieDetails()
    }
}