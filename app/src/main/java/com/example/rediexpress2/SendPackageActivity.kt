package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SendPackageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_send_package)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.toolbar4))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_square_right)
        var address1: EditText =findViewById(R.id.address1)
        var address2: EditText =findViewById(R.id.address2)
        var country_state1: EditText =findViewById(R.id.country1)
        var country_state2: EditText =findViewById(R.id.country2)
        var phone1: EditText =findViewById(R.id.phone_number1)
        var phone2: EditText =findViewById(R.id.phone_number2)
        var package_item: EditText =findViewById(R.id.package_item)
        var weigth: EditText =findViewById(R.id.weight_item)
        var worth: EditText =findViewById(R.id.worth_items)
        var instant_delivery: AppCompatButton =findViewById(R.id.instant_delivery)
        var scheduled_delivery: AppCompatButton =findViewById(R.id.scheduled_delivery)
        instant_delivery.setOnClickListener {
            if (address1.text.isNotEmpty()&&address2.text.isNotEmpty()&&country_state1.text.isNotEmpty()
                &&country_state2.text.isNotEmpty()&&phone1.text.isNotEmpty()&&phone2.text.isNotEmpty()
                &&package_item.text.isNotEmpty()&&weigth.text.isNotEmpty()&&worth.text.isNotEmpty()){
                val intent= Intent(this@SendPackageActivity, SendPackageReceiptActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Заполните обязательные текстовые поля", Toast.LENGTH_SHORT).show()
            }
        }
        scheduled_delivery.setOnClickListener {

        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            super.onBackPressed()
        }
        return true
    }
}