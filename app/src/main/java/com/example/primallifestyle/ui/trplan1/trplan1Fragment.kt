package com.example.primallifestyle.ui.trplan1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentTrplan1Binding
import com.example.primallifestyle.ui.trplan1.trplan1FragmentDirections


class trplan1Fragment : Fragment(){

    private lateinit var trplan1ViewModel: trplan1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTrplan1Binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trplan1, container, false
        )

        val sharedPreferences =
            requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        binding.ratingBar.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val rateValue: String = java.lang.String.valueOf(ratingBar.getRating())
            println("Rate for Module is$rateValue")
            editor.putString("Trainingsplan1", rateValue)
            editor.apply()

            val rating1 = sharedPreferences.getString("Trainingsplan1", "").toString()
            println("Value from Get is $rating1")

            binding.button3.setOnClickListener { view: View ->
                val action = trplan1FragmentDirections.actionNavTrplan1FragmentToNavTraining()
                view.findNavController().navigate(action)
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

