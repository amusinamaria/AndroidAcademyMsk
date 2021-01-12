package com.github.amusinamaria.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.amusinamaria.databinding.FragmentDetailsBinding
import com.github.amusinamaria.repository.data.Movie
import com.github.amusinamaria.viewmodels.DetailsVMFactory
import com.github.amusinamaria.viewmodels.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(), Observer<Movie> {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var actorsAdapter: ActorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie: Movie = arguments?.getParcelable(MOVIE_ARGS_KEY)!!
        val viewModel: DetailsViewModel by viewModels { DetailsVMFactory(movie) }
        viewModel.movieDetails.observe(this.viewLifecycleOwner, this::onChanged)

        actorsAdapter = ActorsAdapter().apply {
            setHasStableIds(true)
        }
        binding.apply {
//            backArrow.setOnClickListener {
//                fragmentManager?.popBackStack()
//            }
            detailsActorsRecycler.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = actorsAdapter
            }
        }
    }

    override fun onChanged(movieDetails: Movie) {
        actorsAdapter.bindActorsCards(movieDetails.actors)
        binding.detailsToolbar.title = movieDetails.title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val MOVIE_ARGS_KEY = "movie"

        fun newInstance(movie: Movie): DetailsFragment {
            val detailsFragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable(MOVIE_ARGS_KEY, movie)
            detailsFragment.arguments = args
            return detailsFragment
        }
    }
}
