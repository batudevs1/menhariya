package com.example.menhariya

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Ticket_DetailFragment:Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.ticketinfo, container, false)
    }


    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }




    companion object {


        fun newInstance(id: Long): Ticket_DetailFragment{
            val detail = Ticket_DetailFragment()
            val args = Bundle()
            args.putLong("id",id)
            detail.arguments = args

            return detail
        }

    }
}