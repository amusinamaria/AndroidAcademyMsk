package com.example.androidacademymsk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private var goToDetailButton: Button? = null
    private var listener: MovieClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToDetailButton = view.findViewById<Button>(R.id.goToDetailButton).apply {
            setOnClickListener {
                listener?.onClickShowMovieDetails()
            }
        }
    }

    fun setListener(l: MovieClickListener) {
        listener = l
    }

    interface MovieClickListener {
        fun onClickShowMovieDetails()
    }
}