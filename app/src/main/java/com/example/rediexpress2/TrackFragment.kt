package com.example.rediexpress2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton


class TrackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val l= inflater.inflate(R.layout.fragment_track, container, false)
        var but_info:AppCompatButton=l.findViewById(R.id.button_info)
        but_info.setOnClickListener {
            val intent=Intent(activity, SendPackageActivity2::class.java)
            startActivity(intent)
        }
        return l
    }

}