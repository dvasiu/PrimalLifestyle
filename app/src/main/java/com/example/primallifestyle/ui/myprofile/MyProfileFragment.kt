package com.example.primallifestyle.ui.myprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.primallifestyle.R
import kotlinx.android.synthetic.main.fragment_myprofile.*

class MyProfileFragment : Fragment() {

    private lateinit var myProfileViewModel: MyProfileViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myProfileViewModel =
                ViewModelProviders.of(this).get(MyProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_myprofile, container, false)



        return root
    }
}
