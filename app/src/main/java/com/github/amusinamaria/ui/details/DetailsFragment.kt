package com.github.amusinamaria.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.amusinamaria.databinding.FragmentDetailsBinding
import com.github.amusinamaria.repository.MovieCard
import com.github.amusinamaria.repository.data.Movie

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var castAdapter: CastAdapter
    private lateinit var movieCard: MovieCard

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
        movieCard = arguments?.getParcelable(MOVIE_ARGS_KEY)!!
        castAdapter = CastAdapter().apply {
            setHasStableIds(true)
        }
        binding.apply {
            detailsTitle.text = movieCard.title
            backArrow.setOnClickListener {
                fragmentManager?.popBackStack()
            }
            castRecycler.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = castAdapter
            }
        }
    }

    override fun onStart() {
        super.onStart()
        updateCastData()
    }

    private fun updateCastData() {
        castAdapter.bindCastCards(movieCard.cast)
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
