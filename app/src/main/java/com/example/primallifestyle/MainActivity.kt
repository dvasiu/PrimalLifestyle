package com.example.primallifestyle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_myprofile_edit.*


class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_training, R.id.nav_myprofile, R.id.nav_myprofile_edit, R.id.nav_bmi, R.id.nav_calories, R.id.nav_quizFragment), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)





//        //Shared Preferences
//        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
//
//        //handle save button click. input data and save in shared preferences
//        saveButtonProfile.setOnClickListener{
//            //input data
//            val username = editUsernameProfile.text.toString().trim()
//            val age = Integer.parseInt(editAge.text.toString().trim())
//            val weight = Integer.parseInt(editWeight.text.toString().trim())
//
//            //edit data
//            val editor = sharedPreferences.edit()
//            //put data in shared preferences
//            editor.putString("NAME", username)
//            editor.putInt("AGE", age)
//            editor.putInt("WEIGHT", weight)
//
//            //Apply changes to shared preferences
//            editor.apply()
//
//        }
//

  }




















//
//    private fun saveData() {
//        if(editUsername.text.isEmpty()) {
//            editUsername.error = "Please enter a name"
//            return
//        }
//
//        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)
//
//        val editor = mypref.edit()
//
//        editor.putString("username", editUsername.text.toString())
//        editor.apply()
//        Toast.makeText(this, "DAta saved", Toast.LENGTH_LONG).show()
//    }
//














    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    //saving data
//    fun saveData(view: View) {
//        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
//        with(sharedPref.edit()) {
//            putString("name", editUsername.text.toString())
//            putInt("number", editAge.text.toString().toInt())
//            commit()
//        }
//    }
//
//    //saving data
//    fun saveData(view: View) {
//        val sharedPref = this.getSharedPreferences(getString(R.string.editUsername), Context.MODE_PRIVATE) ?: return
//        with(sharedPref.edit()) {
//            putString("name", username.text.toString())
//            putInt("number", editAge.text.toString().toInt())
//            commit()
//        }
//    }
//
//    fun getData(view: View) {
//        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
//        val str_name = sharedPref.getString("name", "")
//        val int_number = sharedPref.getInt("number", 0)
//        Toast.makeText(this, "$str_name $int_number", Toast.LENGTH_LONG).show()
//
//    }

}
