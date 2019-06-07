package com.example.menhariya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.signup.view.*

class Signup_Fragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view= inflater.inflate(R.layout.signup, container, false)

        val nameText= view.name_Text
        val useridText =view.userid_Text
        val bank=view.bank_Text
        val password=view.password_Text
        val signupButton=view.signup_Button

        signupButton.setOnClickListener {


        }

        return  view
    }



}