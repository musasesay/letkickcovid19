package com.letskickcorona.app.ui

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.letskickcorona.app.*

class Main2Activity : AppCompatActivity() {

    private val navigasjonen = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.navigation_home -> {
                val intent = Intent(this@Main2Activity, Main2Activity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_donate -> {
                val intent = Intent(this@Main2Activity, DonateActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_about -> {
                val intent = Intent(this@Main2Activity, AboutActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_becomeamember -> {
                val intent = Intent(this@Main2Activity, RegisterActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
//            R.id.navigation_home -> {
//                return@OnNavigationItemSelectedListener true
//            }
        }
        false

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val bottomNavigation = findViewById<BottomNavigationView>(R.id.navigationView)
        setContentView(R.layout.activity_main2)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.navigationView)
        //bottomNavigation.setSelectedItemId(R.id.home)
        bottomNavigation.setOnNavigationItemSelectedListener(navigasjonen)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
