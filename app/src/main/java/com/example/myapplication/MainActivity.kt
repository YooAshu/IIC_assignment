package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setItemIconTintList(null);




        val homeFragement = homeFragment();
        val notificationFragement = notificationFragment();
        val profileFragement = profileFragment();
        val reportFragement = reportFragment();

        makeCurrentFragment(homeFragement);

       findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
           when(it.itemId){
               R.id.home-> makeCurrentFragment(homeFragement)
               R.id.profile-> makeCurrentFragment(profileFragement)

           }
           true
       }
    }

    private fun makeCurrentFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.constrain,fragment)
            commit()
        }

    }
}


