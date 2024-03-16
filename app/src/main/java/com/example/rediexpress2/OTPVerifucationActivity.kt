package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.chaos.view.PinView
import kotlin.math.floor
import kotlin.math.roundToInt

class OTPVerifucationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otpverifucation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var otp: PinView =findViewById(R.id.pinView)
        var text_timer: TextView =findViewById(R.id.textResend)
        var btn_to_new_pass: AppCompatButton =findViewById(R.id.button_new_pass)
        otp.addTextChangedListener {
            otp.setLineColor(getResources().getColor(R.color.primarycolor))
            if (otp.text.toString().length==6){
                btn_to_new_pass.isEnabled=true
            }
        }
        btn_to_new_pass.setOnClickListener {
            var code=123456
            if (otp.text.toString()==code.toString()){
                val intent= Intent(this@OTPVerifucationActivity, NewPasswordActivity::class.java)
                startActivity(intent)
            }
            else{
                otp.setLineColor(getResources().getColor(R.color.errorcolor))
            }
        }
        val timer = object: CountDownTimer(60000,1000){
            override fun onTick(p0: Long) {
                var i:Int= floor((p0.toFloat() / 1000.0)).roundToInt()
                if (i<10){
                    text_timer.setText(" resend after 0:0"+i)
                }
                else{
                    text_timer.setText(" resend after 0:"+i)
                }
                text_timer.setTextColor(getResources().getColor(R.color.gray2))
                text_timer.isEnabled=false
            }

            override fun onFinish() {
                text_timer.setText(" resend")
                text_timer.setTextColor(getResources().getColor(R.color.primarycolor))
                text_timer.isEnabled=true
            }


        }
        timer.start()

        text_timer.setOnClickListener {
            text_timer.setText(" resend after 1:00")
            timer.start()
        }

    }
}