package com.example.rediexpress2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
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

var Table_user="USER"
//var key_name="full_name"
//var key_phone="phone"
var key_email="email"
var key_pass="password"
var key_rem="isRemember"
class LogInActivity : AppCompatActivity() {
    var user_preff:SharedPreferences?=null
    val pattern:String="[a-z0-9]{1,100}"+"@"+"[a-z]{1,10}"+"\\."+"[a-z]{1,5}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        user_preff=getSharedPreferences(Table_user, MODE_PRIVATE)
        var email: EditText =findViewById(R.id.editTextTextEmailAddress2)
        var pass: EditText =findViewById(R.id.editTextTextPassword4)
        var text_forgot: TextView =findViewById(R.id.textForgotPass)
        var text_sign_up: TextView =findViewById(R.id.sign_up_text)
        var  btn_log: AppCompatButton =findViewById(R.id.btn_log_in)
        var rem_cb:CheckBox=findViewById(R.id.checkBox2)
        email.addTextChangedListener {
            btn_log.isEnabled=email.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()
        }
        pass.addTextChangedListener {
            btn_log.isEnabled=email.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()
        }
        text_forgot.setOnClickListener {
            val intent= Intent(this@LogInActivity, ForgotActivity::class.java)
            startActivity(intent)
        }
        text_sign_up.setOnClickListener {
            val intent= Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
        btn_log.setOnClickListener {
            if (EmailValid(email.text.toString())){
                user_preff?.edit()?.putString(key_email, email.text.toString())?.apply()
                user_preff?.edit()?.putString(key_pass, pass.text.toString())?.apply()
                user_preff?.edit()?.putBoolean(key_rem, rem_cb.isChecked)?.apply()
                val intent= Intent(this@LogInActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Email введен некоректно", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun EmailValid(text:String):Boolean{
        return Pattern.compile(pattern).matcher(text).matches()
    }
}