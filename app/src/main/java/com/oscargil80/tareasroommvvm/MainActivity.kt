package com.oscargil80.tareasroommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {


    //lateinit var navController: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyToolbar().show(this, "Actividad 1", false)



     /*   val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
         navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

       /* navController = findNavController(R.id.fragmentContainerView)

        setupActionBarWithNavController(navController)
        this.supportActionBar?.setTitle("Holaaaa")*/

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  false
    }

    override fun onNavigateUp(): Boolean {
        return  super.onNavigateUp()
    }
}