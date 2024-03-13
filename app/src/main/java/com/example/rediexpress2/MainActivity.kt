package com.example.rediexpress2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var preff: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        preff= getSharedPreferences(TABLE,MODE_PRIVATE)
        var skip=preff?.getBoolean(key1, false)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val timer=object :CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                if (skip==true){
                    var intent= Intent(this@MainActivity, HolderActivity::class.java)
                    startActivity(intent)
                }else{
                    var intent= Intent(this@MainActivity, OnboardActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timer.start()
    }
}