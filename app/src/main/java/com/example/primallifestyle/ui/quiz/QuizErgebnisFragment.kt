package com.example.primallifestyle.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentQuizErgebnisBinding
import com.example.primallifestyle.ui.quiz.QuizErgebnisFragmentDirections

class QuizErgebnisFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentQuizErgebnisBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_ergebnis, container, false
        )

        val args: QuizErgebnisFragmentArgs by navArgs()

        binding.textView3.text = args.score

        binding.nextMatchButton.setOnClickListener { view: View ->
            val action = QuizErgebnisFragmentDirections.actionQuizErgebnisFragmentToNavQuizFragment()
            view.findNavController().navigate(action)
        }

        binding.button3.setOnClickListener { view: View ->
            val action = QuizErgebnisFragmentDirections.actionQuizErgebnisFragmentToNavHome()
            view.findNavController().navigate(action)
        }

        return binding.root
    }
}
