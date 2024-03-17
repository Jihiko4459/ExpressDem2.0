package com.example.rediexpress2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DeliverySuccessfulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delivery_successful)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pb:ProgressBar=findViewById(R.id.progressBar2)
        val timer=object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                pb.indeterminateDrawable=getDrawable(R.drawable.goodtick_drawable)//как изменить...
            }

        }
        timer.start()
        var but_done:AppCompatButton=findViewById(R.id.btn_done)
        but_done.setOnClickListener {
            val intent=Intent(this@DeliverySuccessfulActivity, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}