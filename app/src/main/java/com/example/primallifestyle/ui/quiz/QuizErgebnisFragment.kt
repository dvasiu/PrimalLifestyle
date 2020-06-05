package com.example.primallifestyle.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentQuizErgebnisBinding

class QuizErgebnisFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentQuizErgebnisBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_ergebnis, container, false
        )
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_quizErgebnisFragment_to_nav_quizFragment)
        }
        return binding.root
    }
}
