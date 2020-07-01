package com.example.primallifestyle.ui.myprofile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.primallifestyle.R
import com.example.primallifestyle.databinding.FragmentMyprofileBinding

class MyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentMyprofileBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_myprofile, container, false
        )
        binding.setLifecycleOwner(this)
        binding.editButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_myprofile_to_nav_myprofile_edit)
        }

        //Shared Preferences
        val sharedPreferences =
            requireActivity().getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        binding.editUsername.text = sharedPreferences.getString("NAME", "")
        binding.editAge.text = sharedPreferences.getString("AGE", "").toString()
        binding.editWeight.text = sharedPreferences.getString("WEIGHT", "").toString()
        binding.editHeight.text = sharedPreferences.getString("HEIGHT", "").toString()
//        binding.nonEditScore.text = sharedPreferences.getString("SCORE", "").toString()



return binding.root
    }
}

