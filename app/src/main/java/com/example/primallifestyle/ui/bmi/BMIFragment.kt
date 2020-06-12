package com.example.primallifestyle.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primallifestyle.R

class BMIFragment : Fragment() {

    private lateinit var bmiViewModel: BMIViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bmiViewModel =
                ViewModelProvider(this).get(BMIViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bmi, container, false)
        val textView: TextView = root.findViewById(R.id.text_bmi)
        bmiViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
