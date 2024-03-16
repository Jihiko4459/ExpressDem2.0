package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import java.util.regex.Pattern

class ForgotActivity : AppCompatActivity() {
    val pattern:String="[a-z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,5}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var email: EditText =findViewById(R.id.email_et3)
        var btn_send: AppCompatButton =findViewById(R.id.buttonSend)
        var text_singin: TextView =findViewById(R.id.text_sign_in)
        email.addTextChangedListener {
            btn_send.isEnabled=email.text.toString().isNotEmpty()
        }
        btn_send.setOnClickListener {
            if (EmailValid(email.text.toString())){
                var intent= Intent(this@ForgotActivity, OTPVerifucationActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Email введен некоректно", Toast.LENGTH_SHORT).show()
            }

        }
        text_singin.setOnClickListener {
            var intent= Intent(this@ForgotActivity, LogInActivity::class.java)
            startActivity(intent)
        }
    }
    fun EmailValid(text:String):Boolean{
        return Pattern.compile(pattern).matcher(text).matches()
    }
}