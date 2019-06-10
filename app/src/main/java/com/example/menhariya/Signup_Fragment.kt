package com.example.menhariya

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.menhariya.data.User
import com.example.menhariya.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.signup.*
import kotlinx.android.synthetic.main.signup.view.*

class Signup_Fragment:Fragment() {

    private lateinit var userViewModel: UserViewModel

    private lateinit var nameText:EditText

    private lateinit var useridText:EditText

    private lateinit var bank:EditText

    private lateinit var password:EditText

    private lateinit var signupButton:Button

    private lateinit var back:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

    }



    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view= inflater.inflate(R.layout.signup, container, false)

        val activity = activity as MainActivity


        val isConnected = activity?.connected()


        nameText= view.name_Text
        useridText =view.userid_Text
         bank=view.bank_Text
        password=view.password_Text
        signupButton=view.signup_Button

        back=view.back_button


        back.setOnClickListener {
            (activity as NavigationHost).navigateTo(Login_Fragment(),false)

        }


        signupButton.setOnClickListener {


            if(isConnected!!) {
                userViewModel.newUser(readFields())
                clearFields()

            }


        }

        return  view
    }

    private fun readFields() = User(
        0,
        useridText.text.toString(),
        nameText.text.toString(),
        bank.text.toString(),
        password.text.toString()
    )

    private fun clearFields() {
        useridText.setText("")
        nameText.setText("")
        bank.setText("")
        password.setText("")
    }

}