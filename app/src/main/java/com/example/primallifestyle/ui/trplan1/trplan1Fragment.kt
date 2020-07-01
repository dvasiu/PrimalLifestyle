package com.example.primallifestyle.ui.trplan1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentTrplan1Binding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_trplan1.*


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

//        binding.ratingBar.setOnRatingBarChangeListener(ratingBar, )



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

