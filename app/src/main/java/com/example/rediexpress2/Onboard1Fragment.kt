package com.example.rediexpress2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton

var TABLE="Table_onboard"
var key1="isCheck"
var key2="Number_Screen"
class Onboard1Fragment : Fragment() {

    var preff: SharedPreferences?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var q= inflater.inflate(R.layout.fragment_onboard1, container, false)
        var but_skip: AppCompatButton =q.findViewById(R.id.button_skip1)
        preff= activity?.getSharedPreferences(TABLE, Context.MODE_PRIVATE)
        preff?.edit()?.putInt(key2, 0)?.apply()
        but_skip.setOnClickListener{
            var intent= Intent(activity, HolderActivity::class.java)
            preff?.edit()?.putBoolean(key1, true)?.apply()
            startActivity(intent)
        }
        return q
    }


}