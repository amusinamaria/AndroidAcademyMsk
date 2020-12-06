package com.example.androidacademymsk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    private var castRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            fragmentManager?.popBackStack()
        }
        castRecycler = view.findViewById(R.id.castRecycler)
        castRecycler?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        castRecycler?.setHasFixedSize(true)
        val adapter = CastAdapter()
        adapter.setHasStableIds(true)
        castRecycler?.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        updateCastData()
    }

    private fun updateCastData() {
        (castRecycler?.adapter as? CastAdapter)?.apply {
            bindCastCards(MockDataSource().getCastCards())
        }
    }
}
