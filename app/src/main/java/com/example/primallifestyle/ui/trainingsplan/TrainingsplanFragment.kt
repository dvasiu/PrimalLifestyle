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
        val textView: TextView = root.findViewById(R.id.textView)
        trainingsplanViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it


            val expTv: ExpandableTextView = root.findViewById(R.id.expand_text_view)
            expTv.setText("Expandable Text View is an android library that allows the users to create the text view which can expand and collapse to read the text description. I bet you guys have seen this in a lot of android applications but might not know the name and its purpose. Well, below is a screenshot of the Instagram application on the Play store. This feature saves a lot of space, rather than laying out the huge chunks of information and occupying the entire page we can further use this option and can utilize the space")

        })
        return root
    }
}
