package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransactionSuccessfulActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transaction_successful2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var go_track: AppCompatButton =findViewById(R.id.btn_track)
        var go_home: AppCompatButton =findViewById(R.id.btn_go_home)
        go_track.setOnClickListener {
            val intent=
                Intent(this@TransactionSuccessfulActivity2, HomeActivity::class.java) //home->track in bn?

            startActivity(intent)
        }
        go_home.setOnClickListener {
            val intent= Intent(this@TransactionSuccessfulActivity2, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}