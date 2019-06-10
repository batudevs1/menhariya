package com.example.menhariya

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login.view.*
import kotlinx.android.synthetic.main.login.view.password_Text
import kotlinx.android.synthetic.main.login.view.userid_Text
import kotlinx.android.synthetic.main.signup.view.*

class Login_Fragment:Fragment() {

private lateinit var login:Button

    private  lateinit var signupButton:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val activity = activity as MainActivity?

      val view=inflater.inflate(R.layout.login, container, false)

        val uname=view.userid_Text
        val psd=view.password_Text
         login=view.login_Button
         signupButton=view.tosignup_Button

        login.setOnClickListener {

            (activity as NavigationHost).navigateTo(ViewpagerFragment(), false)
        }

        signupButton.setOnClickListener {
            (activity as NavigationHost).navigateTo(Signup_Fragment(), true)

        }

        return view

    }


}