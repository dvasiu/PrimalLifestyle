package com.example.primallifestyle.ui.trplan2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentTrplan2Binding
import com.google.android.material.snackbar.Snackbar
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.navigation.findNavController


class trplan2Fragment : Fragment() {

    private lateinit var trplan2ViewModel: trplan2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTrplan2Binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trplan2, container, false
        )

        val sharedPreferences =
            requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        binding.ratingBar2.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val rateValue: String = java.lang.String.valueOf(ratingBar.getRating())
            println("Rate for Module is$rateValue")
            editor.putString("Trainingsplan2", rateValue)
            editor.apply()

            val rating2 = sharedPreferences.getString("Trainingsplan2", "").toString()
            println("Value from Get is $rating2")

            binding.button3.setOnClickListener { view: View ->
                val action = trplan2FragmentDirections.actionTrplan2FragmentToNavTraining()
                view.findNavController().navigate(action)
               // view.findNavController().navigate(R.id.action_nav_training_to_nav_trplan1Fragment)
            }

        })
//        trplan1ViewModel =
//            ViewModelProvider(this).get(trplan1ViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_trplan1, container, false)
//        val textView: TextView = root.findViewById(R.id.trplan1ID)
//        trplan1ViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it }
//        )


        return binding.root
    }
}