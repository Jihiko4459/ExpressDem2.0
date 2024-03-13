package com.example.rediexpress2

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class OnboardActivity : AppCompatActivity() {
    var preff:SharedPreferences?=null
    var fragmentlist= listOf<Fragment>(Onboard1Fragment(), Onboard2Fragment(), Onboard3Fragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        preff=getSharedPreferences(TABLE, MODE_PRIVATE)
        var index:Int= preff?.getInt(key2, 0)!!
        supportFragmentManager.beginTransaction().replace(R.id.vpager2, fragmentlist[index]).commit()

    }
    fun next1(view: View) {
        supportFragmentManager.beginTransaction().setTransition(
            FragmentTransaction.TRANSIT_FRAGMENT_FADE
        ).replace(R.id.vpager2, Onboard2Fragment()).commit()
    }

    fun next2(view: View) {
        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE
        ).replace(R.id.vpager2, Onboard3Fragment()).commit()
    }

}