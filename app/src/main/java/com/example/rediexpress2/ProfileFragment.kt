package com.example.rediexpress2

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView

val Table_dark_mode="Table_dark_mode"
val key_is_dark="key_is_dark"
class ProfileFragment : Fragment() {

    var preff: SharedPreferences?=null
    var preff_dark:SharedPreferences?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val l = inflater.inflate(R.layout.fragment_profile, container, false)
        preff=activity?.getSharedPreferences(Table_user, MODE_PRIVATE)
        preff_dark=activity?.getSharedPreferences(Table_dark_mode, MODE_PRIVATE)
        var switch_dark_light: Switch =l.findViewById(R.id.switch2)
        if (preff_dark?.getBoolean(key_is_dark, false) == true){
            switch_dark_light.isChecked=true
        }
        else{
            switch_dark_light.isChecked=false
        }
        switch_dark_light.setOnClickListener {
            if(switch_dark_light.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                preff_dark?.edit()?.putBoolean(key_is_dark, true)?.apply()
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                preff_dark?.edit()?.putBoolean(key_is_dark, false)?.apply()
            }
        }
        var btn_hide: CheckBox =l.findViewById(R.id.cb_eye1)
        var notific: CardView =l.findViewById(R.id.item3)
        var statements_reports: CardView =l.findViewById(R.id.item2)
        var cardset: CardView =l.findViewById(R.id.item4)
        var logout: CardView =l.findViewById(R.id.item7)
        var txt_balance: TextView =l.findViewById(R.id.textView37)
        statements_reports.setOnClickListener {
            val intent= Intent(activity, SendPackageActivity::class.java)
            startActivity(intent)
        }
        notific.setOnClickListener {
            val intent= Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }
        cardset.setOnClickListener {
            val intent= Intent(activity, AddPaymentMethodActivity::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            val intent= Intent(activity, LogInActivity::class.java)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            preff_dark?.edit()?.putBoolean(key_is_dark, false)?.apply()
            preff?.edit()?.putBoolean(key_rem, false)?.apply()
            preff?.edit()?.putString(key_email, "")?.apply()
            preff?.edit()?.putString(key_pass, "")?.apply()
            startActivity(intent)
        }
        btn_hide.setOnClickListener {
            if (btn_hide.isChecked){
                txt_balance.setText(" **********")
            }
            else{
                txt_balance.setText(" "+"N10,712:00")
                //достать балланс с сервера
            }
        }
        return l
    }

}