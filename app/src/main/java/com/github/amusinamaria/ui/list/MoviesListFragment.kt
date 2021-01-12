package com.github.amusinamaria.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.FragmentMoviesListBinding
import com.github.amusinamaria.repository.data.Movie
import com.github.amusinamaria.ui.MainActivity
import com.github.amusinamaria.viewmodels.MoviesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment(), Observer<List<Movie>> {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var viewModel: MoviesListViewModel

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
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)
        viewModel.movies.observe(this.viewLifecycleOwner, this::onChanged)
        val columnsCount: Int = resources.getInteger(R.integer.movie_cards_column_count)
        binding.moviesRecycler.apply {
            layoutManager = GridLayoutManager(context, columnsCount)
            addItemDecoration(MoviesRVSpacingDecoration(columnsCount))
        }
        moviesAdapter = MoviesAdapter { (activity as MainActivity).showMovieDetails(it) }
        binding.moviesRecycler.adapter = moviesAdapter
    }

    override fun onChanged(newMovies: List<Movie>) {
        moviesAdapter.bindMovieCards(newMovies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
