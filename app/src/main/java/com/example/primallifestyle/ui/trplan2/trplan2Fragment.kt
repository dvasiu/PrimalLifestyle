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


//
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