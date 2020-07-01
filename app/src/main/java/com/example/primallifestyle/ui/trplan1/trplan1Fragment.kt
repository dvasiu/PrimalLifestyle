package com.example.primallifestyle.ui.trplan1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentTrplan1Binding


class trplan1Fragment : Fragment() {

    private lateinit var trplan1ViewModel: trplan1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTrplan1Binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trplan1, container, false
        )


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