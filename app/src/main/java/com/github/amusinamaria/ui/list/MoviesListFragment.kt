package com.github.amusinamaria.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.FragmentMoviesListBinding
import com.github.amusinamaria.repository.MockDataSource
import com.github.amusinamaria.ui.MainActivity


class MoviesListFragment : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesRecycler: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesRecycler = binding.moviesRecycler
        val columnsCount: Int = resources.getInteger(R.integer.movie_cards_column_count)
        moviesRecycler.apply {
            layoutManager = GridLayoutManager(context, columnsCount)
            addItemDecoration(MovieCardsSpacingDecoration(columnsCount))
        }
        moviesAdapter = MoviesAdapter { (activity as MainActivity).showMovieDetails(it) }
        moviesRecycler.adapter = moviesAdapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
