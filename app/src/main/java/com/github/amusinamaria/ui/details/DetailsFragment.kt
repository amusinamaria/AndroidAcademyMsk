package com.github.amusinamaria.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.amusinamaria.R
import com.github.amusinamaria.repository.MovieCard
import com.github.amusinamaria.ui.MainActivity.Companion.MOVIE_ARGS_KEY

class DetailsFragment : Fragment() {

    private lateinit var castRecycler: RecyclerView
    private lateinit var castAdapter: CastAdapter
    private lateinit var movieCard: MovieCard

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieCard = arguments?.getParcelable(MOVIE_ARGS_KEY)!!
        val movieTitle: TextView = view.findViewById(R.id.detailsTitle)
        movieTitle.text = movieCard.title

        view.findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            fragmentManager?.popBackStack()
        }
        castRecycler = view.findViewById(R.id.castRecycler)
        castRecycler.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        castAdapter = CastAdapter().apply {
            setHasStableIds(true)
        }
        castRecycler.adapter = castAdapter
    }

    override fun onStart() {
        super.onStart()
        updateCastData()
    }

    private fun updateCastData() {
        castAdapter.apply {
            bindCastCards(movieCard.cast)
        }
    }
}
