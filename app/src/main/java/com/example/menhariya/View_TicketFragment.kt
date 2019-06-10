package com.example.menhariya

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menhariya.data.Ticket
import com.example.menhariya.viewmodel.TicketViewModel
import com.example.menhariya.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.ticket_view.view.*

class View_TicketFragment:Fragment() {
    private lateinit var ticketViewModel: TicketViewModel
    private lateinit var userViewModel: UserViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var allTicket: List<Ticket>
   private lateinit var carplate:TextView
    private lateinit var start:TextView
    private lateinit var destination:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel::class.java)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.ticket_view, container, false)
        val activity = activity as MainActivity?


        val isConnected = activity?.connected()


        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = Detail_Adapter(allTicket = this.allTicket)
        recyclerView.setHasFixedSize(true)









        ticketViewModel.getAllTickets().observe(this, Observer {
            recyclerView.adapter = Detail_Adapter(it)
        })


        if(isConnected!!) {
            ticketViewModel.getTicketById(5).observe(this, Observer {
                val ticket = it

                carplate.text = ticket?.car_plate
                start.text = ticket?.start
              destination.text = ticket?.destination
            })
        }


        return view
    }


}