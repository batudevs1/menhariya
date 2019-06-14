package com.example.menhariya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.menhariya.data.Ticket
import com.example.menhariya.view.NavigationHost
import com.example.menhariya.viewmodel.TicketViewModel
import kotlinx.android.synthetic.main.add_ticket.view.*

class AddTicket_Fragment:Fragment() {

    private lateinit var carplate:EditText
    private lateinit var start:EditText
    private lateinit var destination:EditText
    private lateinit var chairno:EditText
    private lateinit var cartype:EditText
    private lateinit var date:EditText
    private lateinit var driverid:EditText
    private lateinit var price:EditText
    private lateinit var addbutton:Button
    private lateinit var backbutton:Button
    private lateinit var ticketViewModel:TicketViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.add_ticket, container, false)
                carplate=view.carplate_Text
                start=view.start_Text
                destination=view.destination_Text
                chairno=view.chairno_Text
                cartype=view.cartype_Text
                date=view.date_Text
                driverid=view.driverid_Text
                addbutton=view.add_Button
                backbutton=view.back_button
                price=view.price_Text

               val activity = activity as MainActivity?


                 val isConnected = activity?.connected()
                 addbutton.setOnClickListener {


                    if(isConnected!!) {
                        ticketViewModel.addTicket(readFields())
                        clearFields()
                        (activity as NavigationHost).navigateTo(View_TicketFragment(), true)
                    }




                }





        return view
    }


    private fun readFields() = Ticket(
        0,
        carplate.text.toString(),
        start.text.toString(),
        destination.text.toString(),
        cartype.text.toString(),
        price.text.toString(),
        chairno.text.toString(),
        driverid.text.toString(),
        date.text.toString()



    )

    private fun clearFields() {
        carplate.setText("")
        start.setText("")
        destination.setText("")
        cartype.setText("")
        price.setText("")
        chairno.setText("")
        driverid.setText("")
        date.setText("")
    }
}