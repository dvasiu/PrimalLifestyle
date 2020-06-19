package com.example.primallifestyle.ui.myprofile

import android.content.Context
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
import kotlinx.android.synthetic.main.fragment_myprofile.*
import com.example.primallifestyle.ui.myprofile_edit.*
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

        }
//        binding.nonEditScore.text = testingVar

        //Shared Preferences
        val sharedPreferences =
            requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

//        //handle save button click. input data and save in shared preferences
//        binding.saveBtn.setOnClickListener {
//            //input data
//            val username = binding.editUsername.text.toString().trim()
////            val age = Integer.parseInt(editAge.text.toString().trim())
////            val weight = Integer.parseInt(editWeight.text.toString().trim())
//
//            //edit data
//            val editor = sharedPreferences.edit()
//            //put data in shared preferences
//            editor.putString("NAME", username)
////            editor.putInt("AGE", age)
////            editor.putInt("WEIGHT", weight)
//
//            //Apply changes to shared preferences
//            editor.apply()
//        }

        binding.editUsername.text = sharedPreferences.getString("NAME", "")
        binding.editAge.text = sharedPreferences.getInt("AGE", 0).toString()
        binding.editWeight.text = sharedPreferences.getInt("WEIGHT", 0).toString()
//
//        binding.showInfoBtn.setOnClickListener{
//            val username = sharedPreferences.getString("NAME", "")
//            val age = sharedPreferences.getInt("AGE", 0)
//            val weight = sharedPreferences.getInt("WEIGHT", 0)
//
//            infoTV.text = "Name: $username, Age: $age, Weight: $weight"
//        }
        return binding.root
    }
}

