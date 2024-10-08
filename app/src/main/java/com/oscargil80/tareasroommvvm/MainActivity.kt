package com.oscargil80.tareasroommvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.oscargil80.tareasroommvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
 //lateinit  var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main )

        MyToolbar().show(this, "Listado",  false)
      /*  binding.toolbaR.setOnClickListener {
            Toast.makeText(this, "Hola apreaste el toolbar", Toast.LENGTH_SHORT).show();
        }

        binding.boton.setOnClickListener {
            Toast.makeText(this, "Hola apreaste el Boton toolbar", Toast.LENGTH_SHORT).show();
        }*/

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
}