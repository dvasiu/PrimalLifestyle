package com.example.primallifestyle.ui.bmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentBmiBinding
import kotlin.math.pow




class BMIFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding = DataBindingUtil.inflate<FragmentBmiBinding>(
            inflater, R.layout.fragment_bmi, container, false
        )
        binding.berechnen.setOnClickListener {view: View ->
            val cmText = binding.cmValue.getText().toString()
            val cm = Integer.parseInt(cmText)
            val kgText = binding.kgValue.getText().toString()
            val kg = Integer.parseInt(kgText)
            val bmi = cm/(kg*kg)
            val bmiergebnis = bmi.toString()
            binding.bmiValue.text = bmiergebnis
        }
        return binding.root
    }
}

