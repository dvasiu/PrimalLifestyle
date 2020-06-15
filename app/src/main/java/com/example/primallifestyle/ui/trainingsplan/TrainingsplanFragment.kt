package com.example.primallifestyle.ui.trainingsplan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primallifestyle.R
import com.ms.square.android.expandabletextview.ExpandableTextView

class TrainingsplanFragment : Fragment() {

    private lateinit var trainingsplanViewModel: TrainingsplanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trainingsplanViewModel =
            ViewModelProvider(this).get(TrainingsplanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_trainingsplan, container, false)
        val textView: TextView = root.findViewById(R.id.trainingsplan1ID)
        trainingsplanViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it



        })
        return root
    }
}
