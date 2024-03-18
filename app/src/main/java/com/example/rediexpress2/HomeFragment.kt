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
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val l= inflater.inflate(R.layout.fragment_home, container, false)
        var chat:LinearLayout=l.findViewById(R.id.chats)
        chat.setOnClickListener {
            val intent=Intent(activity, ChatsActivity::class.java)
            startActivity(intent)
        }
        return l
    }


}