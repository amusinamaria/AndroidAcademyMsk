package com.github.amusinamaria.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.github.amusinamaria.R
import com.github.amusinamaria.databinding.FragmentMoviesListBinding
import com.github.amusinamaria.repository.data.loadMovies
import com.github.amusinamaria.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MoviesListFragment : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private val scope = CoroutineScope(Dispatchers.Main)

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
        val columnsCount: Int = resources.getInteger(R.integer.movie_cards_column_count)
        binding.moviesRecycler.apply {
            layoutManager = GridLayoutManager(context, columnsCount)
            addItemDecoration(MoviesRVSpacingDecoration(columnsCount))
        }
        moviesAdapter = MoviesAdapter { (activity as MainActivity).showMovieDetails(it) }
        binding.moviesRecycler.adapter = moviesAdapter
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        scope.launch {
            moviesAdapter.apply {
                bindMovieCards(loadMovies(requireContext()))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        scope.cancel()
    }
}
