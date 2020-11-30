package com.example.androidacademymsk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var listener: BackArrowClickListener? = null
    private var backArrow: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backArrow = view.findViewById<ImageView>(R.id.backArrow).apply {
            setOnClickListener {
                listener?.onClickBackArrow()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BackArrowClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface BackArrowClickListener {
        fun onClickBackArrow()
    }
}