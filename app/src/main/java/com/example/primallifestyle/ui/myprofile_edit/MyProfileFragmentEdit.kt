package com.example.primallifestyle.ui.myprofile_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.ui.database.PrimalDatabase
import com.example.primallifestyle.databinding.FragmentMyprofileEditBinding
import com.example.primallifestyle.ui.myprofile.MyProfileViewModelFactory
import com.example.primallifestyle.ui.myprofile.MyProfileViewModelFactoryEdit
import com.example.primallifestyle.ui.myprofile_edit.MyProfileViewModelEdit


class MyProfileFragmentEdit : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        val testingVar: String = "test"

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
        binding.saveButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_myprofile_edit_to_nav_myprofile)
        }

        return binding.root
    }
}

