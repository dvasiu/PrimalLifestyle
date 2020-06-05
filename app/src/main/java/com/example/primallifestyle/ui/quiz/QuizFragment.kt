package com.example.primallifestyle.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.primallifestyle.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.primallifestyle.databinding.FragmentQuizBinding


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
            answers = listOf("Mehr als 8", "Zwischen 4 und 8", "Zwischen 2 und 4", "Weniger als zwei", "Keine")),
        Question(text = "Wie viele Schritte gehst du am Tag?",
            answers = listOf("Weniger als 2.000", "Zwischen 2.000 und 4.000", "Zwischen 4.000 und 6.000", "Zwischen 6.000 und 8.000", "Mehr als 10.000")),
        Question(text = "Wie oft in der Woche machst du Sport?",
            answers = listOf("Nie", "1 Mal", "2 oder 3 Mal", "4 oder 5 Mal", "6 oder 7 Mal")),
        Question(text = "Wie oft in der Woche machst du Dehnübungen (auch Mobilitisation oder Yoga)?",
        answers = listOf("Nie", "1 Mal", "2 oder 3 Mal", "4 oder 5 Mal", "6 oder 7 Mal"))
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

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                var score = 0
                when (checkedId) {
                    R.id.firstAnswerRadioButton -> answerIndex = 0
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                    R.id.fifthAnswerRadioButton -> answerIndex = 4
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    score + 10
                }
                if (answers[answerIndex] == currentQuestion.answers[1]) {
                    score + 7.5
                }
                if (answers[answerIndex] == currentQuestion.answers[2]) {
                    score + 5
                }
                if (answers[answerIndex] == currentQuestion.answers[3]) {
                    score + 2.5
                }
                if (answers[answerIndex] == currentQuestion.answers[4]) {
                    score + 0
                }

                    // Advance to the next question
                questionIndex++
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]

                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(R.id.action_nav_quizFragment_to_quizErgebnisFragment)
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
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        //answers.shuffle()
        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_quiz_question, questionIndex + 1, numQuestions)
    }
}

/*
class QuizFragment : Fragment() {
    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       quizViewModel =
           ViewModelProviders.of(this).get(QuizViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)
        val textView: TextView = root.findViewById(R.id.quiz_text)
        quizViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
        // return super.onCreateView(inflater, container, savedInstanceState)
    }
}

*/
