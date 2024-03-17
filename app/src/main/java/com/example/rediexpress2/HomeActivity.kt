package com.example.rediexpress2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    var fraglist= listOf(HomeFragment(), TrackFragment(), ProfileFragment() )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var bnv:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        supportFragmentManager.beginTransaction().replace(R.id.holder, fraglist[0]).commit()
        bnv.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->supportFragmentManager.beginTransaction().replace(R.id.holder, fraglist[0]).commit()
                R.id.track->supportFragmentManager.beginTransaction().replace(R.id.holder, fraglist[1]).commit()
                R.id.profile->supportFragmentManager.beginTransaction().replace(R.id.holder, fraglist[2]).commit()
            }
            true
        }

    }
}