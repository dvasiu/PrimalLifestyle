package com.example.primallifestyle.ui.myprofile_edit

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.ui.database.PrimalDatabase
import com.example.primallifestyle.databinding.FragmentMyprofileEditBinding
import com.example.primallifestyle.ui.myprofile.MyProfileViewModelFactoryEdit
import com.example.primallifestyle.MainActivity
import kotlinx.android.synthetic.main.fragment_myprofile_edit.*


class MyProfileFragmentEdit : Fragment() {

//    lateinit var editUsername: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentMyprofileEditBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_myprofile_edit, container, false
        )
        val application = requireNotNull(this.activity).application

        //Create an instance of the ViewModel Factory
        val dataSource = PrimalDatabase.getInstance(application).primalDatabaseDao
        val viewModelFactory = MyProfileViewModelFactoryEdit(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment
        val myProfileViewModelEdit =
            ViewModelProvider(this, viewModelFactory).get(MyProfileViewModelEdit::class.java)
        binding.myProfileViewModelEdit = myProfileViewModelEdit
        binding.setLifecycleOwner(this)
//        binding.saveButtonProfile.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_nav_myprofile_edit_to_nav_myprofile)
        /*}*/

        //Shared Preferences
        val sharedPreferences = requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        //handle save button click. input data and save in shared preferences
        binding.saveButtonProfile.setOnClickListener{
            //input data
            val username = editUsernameProfile.text.toString().trim()
//            val age = Integer.parseInt(editAge.text.toString().trim())
//            val weight = Integer.parseInt(editWeight.text.toString().trim())

            //edit data
            val editor = sharedPreferences.edit()
            //put data in shared preferences
//            editor.putString("NAME", username)
//            editor.putInt("AGE", age)
//            editor.putInt("WEIGHT", weight)

            //Apply changes to shared preferences
            editor.apply()

        }




//        editUsername = findViewById(R.id.editUsernameProfile)
//        findViewById<Button>(R.id.saveButtonProfile).setOnClickListener {
//            saveData()
//        }



        return binding.root
    }
}

