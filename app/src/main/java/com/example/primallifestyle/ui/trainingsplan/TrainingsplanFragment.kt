package com.example.primallifestyle.ui.trainingsplan

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentTrainingsplanBinding
import com.ms.square.android.expandabletextview.ExpandableTextView

class TrainingsplanFragment : Fragment() {

    private lateinit var trainingsplanViewModel: TrainingsplanViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentTrainingsplanBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trainingsplan, container, false
        )
        binding.setLifecycleOwner(this)
        binding.buttonTrainingsplan1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_training_to_nav_trplan1Fragment)
        }

        val sharedPreferences =
            requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        var rating1 = sharedPreferences.getString("Trainingsplan1", "0")
        println(rating1)
        if (rating1 != null) {
            binding.ratedBar1.rating = rating1.toFloat()
        }

        var rating2 = sharedPreferences.getString("Trainingsplan2", "0")
        println(rating2)

        if (rating2 != null) {
            binding.ratedBar2.rating = rating2.toFloat()
        }



        binding.buttonTrainingsplan2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_training_to_trplan2Fragment)
        }



//        trainingsplanViewModel =
//            ViewModelProvider(this).get(TrainingsplanViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_trainingsplan, container, false)
//        val textView: TextView = root.findViewById(R.id.trainingsplan1ID)
//        trainingsplanViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//            }
//        )




        return binding.root
    }

}

