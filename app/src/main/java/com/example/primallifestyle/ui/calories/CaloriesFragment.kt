package com.example.primallifestyle.ui.calories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primallifestyle.R

class CaloriesFragment : Fragment() {

    private lateinit var caloriesViewModel: CaloriesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        caloriesViewModel =
                ViewModelProvider(this).get(CaloriesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calories, container, false)
        val textView: TextView = root.findViewById(R.id.text_calories)
        caloriesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
