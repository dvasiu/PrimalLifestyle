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
            var cmText = binding.cmValue.getText().toString()
            println(cmText)
            var cm = cmText.toDouble()
            println(cm)
            var m: Double = cm/100
            println(m)
            var kgText = binding.kgValue.getText().toString()
            println(kgText)
            var kg = kgText.toDouble()
            println(kg)
            var bmidouble: Double = kg/(m*m)
            println(bmidouble)
            var bmi: Int = bmidouble.toInt()
            var bmiergebnis = bmi.toString()
            println(bmiergebnis)
            binding.bmiValue.text = bmiergebnis
        }
        return binding.root
    }
}

