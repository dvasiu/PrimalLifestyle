package com.example.primallifestyle.ui.myprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.ui.database.PrimalDatabase
import com.example.primallifestyle.databinding.FragmentMyprofileBinding
import com.example.primallifestyle.ui.database.PrimalData
import com.example.primallifestyle.ui.database.PrimalDatabaseDao
import com.example.primallifestyle.ui.database.PrimalDatabaseDao_Impl
import com.example.primallifestyle.ui.quiz.QuizFragment
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.coroutines.CoroutineScope


class MyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        val testingVar: String = "test"

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentMyprofileBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_myprofile, container, false
        )
        val application = requireNotNull(this.activity).application
        //Create an instance of the ViewModel Factory
        val dataSource = PrimalDatabase.getInstance(application).primalDatabaseDao
        val viewModelFactory = MyProfileViewModelFactory(dataSource, application)
        // Get a reference to the ViewModel associated with this fragment
        val myProfileViewModel =
            ViewModelProvider(this, viewModelFactory).get(MyProfileViewModel::class.java)
        binding.myProfileViewModel = myProfileViewModel
        binding.setLifecycleOwner(this)
        binding.editButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_myprofile_to_nav_myprofile_edit)

            println("jo")
        }
//        binding.nonEditScore.text = testingVar

        return binding.root
    }
}

