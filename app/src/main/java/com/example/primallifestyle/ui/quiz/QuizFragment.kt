package com.example.primallifestyle.ui.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.primallifestyle.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.primallifestyle.databinding.FragmentQuizBinding
import com.google.android.material.snackbar.Snackbar


class QuizFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (or better yet, not define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "Wie oft isst du in der Woche Fast Food? (Pizza, Kebap, McDonalds, etc..)",
            answers = listOf("nie", "selten", "gelegentlich", "oft", "jeden Tag")),
        Question(text = "Wie oft isst du in der Woche verarbeitetes Fleisch? (Aufschnitt, Aufstriche, Leberkäse, etc)",
            answers = listOf("nie", "selten", "gelegentlich", "oft", "jeden Tag")),
        Question(text = "Wie oft isst du Gemüse?",
            answers = listOf("jeden Tag", "oft", "gelegentlich", "selten", "nie")),
        Question(text = "Wie oft isst du Obst?",
            answers = listOf("jeden Tag", "oft", "gelegentlich", "selten", "nie")),
        Question(text = "Wie oft isst du  Nüsse?",
            answers = listOf("jeden Tag", "oft", "gelegentlich", "selten", "nie")),
        Question(text = "Wie oft isst du unverarbeitetes Fleisch (Filet, Steak, etc)?",
            answers = listOf("nie", "selten", "gelegentlich", "oft", "jeden Tag")),
        Question(text = "Wie viele Stunden verbringst du täglich sitzend (PC, Laptop, Fernsehen)?",
            answers = listOf("Keine", "Weniger als zwei", "Zwischen 2 und 4", "Zwischen 4 und 8", "Mehr als 8")),
        Question(text = "Wie viele Schritte gehst du am Tag?",
            answers = listOf("Mehr als 8.000",  "Zwischen 6.000 und 8.000", "Zwischen 4.000 und 6.000", "Zwischen 2.000 und 4.000", "Weniger als 2.000")),
        Question(text = "Wie oft in der Woche machst du Sport?",
            answers = listOf("6 oder 7 Mal", "4 oder 5 Mal", "2 oder 3 Mal", "1 Mal", "Nie")),
        Question(text = "Wie oft in der Woche machst du Dehnübungen (auch Mobilitisation oder Yoga)?",
        answers = listOf("6 oder 7 Mal", "4 oder 5 Mal", "2 oder 3 Mal", "1 Mal", "Nie"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = questions.size

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        // Sets the question index to the first question.
        randomizeQuestions()
        // Bind this fragment class to the layout
        binding.quiz = this

        var score = 0

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.firstAnswerRadioButton -> answerIndex = 0
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                    R.id.fifthAnswerRadioButton -> answerIndex = 4
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    score += 10
                }
                if (answers[answerIndex] == currentQuestion.answers[1]) {
                    score += 8
                }
                if (answers[answerIndex] == currentQuestion.answers[2]) {
                    score += 6
                }
                if (answers[answerIndex] == currentQuestion.answers[3]) {
                    score += 4
                }
                if (answers[answerIndex] == currentQuestion.answers[4]) {
                    score += 3
                }

                    // Advance to the next question
                questionIndex++
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        println(score)
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        //view.findNavController().navigate(R.id.action_nav_quizFragment_to_quizErgebnisFragment)
                        val action = QuizFragmentDirections.actionNavQuizFragmentToQuizErgebnisFragment(
                            score.toString()
                        )
                        view.findNavController().navigate(action)
                    }
                }

            }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()

    }
}

