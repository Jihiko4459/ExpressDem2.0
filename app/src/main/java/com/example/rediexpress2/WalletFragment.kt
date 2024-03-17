package com.example.rediexpress2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView


class WalletFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val l= inflater.inflate(R.layout.fragment_wallet, container, false)
        var btn_hide: CheckBox =l.findViewById(R.id.radioButton2)
        var txt_balance: TextView =l.findViewById(R.id.txt_balance)
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