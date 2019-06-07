package com.example.menhariya

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login.view.*

class Login_Fragment:Fragment() {

    private lateinit var listener: OnSignupClicked

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is OnSignupClicked) {
            listener = context
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
      val view=inflater.inflate(R.layout.login, container, false)
        val uname=view.userid_Text
        val psd=view.password_Text
        val login=view.login_Button
        val signupText=view.signup_Text

        login.setOnClickListener {
         listener.onLoginClicked()

        }

        signupText.setOnClickListener {
          listener.onSignupClicked()

        }

        return view

    }

    interface OnSignupClicked {
        fun  onSignupClicked()
        fun  onLoginClicked()
    }

    interface OnLoginClicked{
        fun onLoginClicked()
    }
}