package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class NewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pass: EditText =findViewById(R.id.editTextTextPassword2)
        var pass_confirm: EditText =findViewById(R.id.editTextTextPassword5)
        var btn_change_pass: AppCompatButton =findViewById(R.id.button_new_pass)
        pass.addTextChangedListener {
            btn_change_pass.isEnabled=pass.text.toString().isNotEmpty()&&pass_confirm.text.toString().isNotEmpty()
        }
        pass_confirm.addTextChangedListener {
            btn_change_pass.isEnabled=pass.text.toString().isNotEmpty()&&pass_confirm.text.toString().isNotEmpty()
        }
        btn_change_pass.setOnClickListener {
            if(pass.text.toString()==pass_confirm.text.toString()){
                val intent= Intent(this@NewPasswordActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }
        }
    }
}