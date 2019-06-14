package com.example.menhariya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menhariya.data.Ticket
import com.example.menhariya.view.NavigationHost

class Detail_Adapter(private var allTicket: List<Ticket>) :
    RecyclerView.Adapter<Detail_Adapter.TViewHolder>() {
    private lateinit var listener: OnClickListener

    private lateinit var activity: MainActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rView = inflater.inflate(R.layout.ticket_detail, parent, false)
        return TViewHolder(rView)
    }

    override fun getItemCount(): Int {
        return allTicket.size
    }

    fun setData(newTicket: List<Ticket>) {
        this.allTicket = newTicket
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TViewHolder, position: Int) {

        val ticket = allTicket[position]
        holder.carplate.text = ticket.car_plate
        holder.start.text = ticket.start
        holder.destination.text = ticket.destination
        holder.cartype.text =ticket.cartype
        holder.price.text =ticket.price
        holder.date.text = ticket.date


        holder.itemView.setOnClickListener {
            (activity as NavigationHost).navigateTo(
                Ticket_DetailFragment.newInstance(ticket.id),
                true
            )
        }
    }


    class TViewHolder(tView: View) : RecyclerView.ViewHolder(tView) {
        var carplate: TextView = tView.findViewById(R.id.car_plate_id)
        var start: TextView = tView.findViewById(R.id.start_id)
        var destination: TextView = tView.findViewById(R.id.destination_id)
        var cartype: TextView = tView.findViewById(R.id.cartype_id)
        var price: TextView = tView.findViewById(R.id.price_id)
        var date: TextView = tView.findViewById(R.id.date_id)

    }

    interface OnClickListener {
        fun onItemClick(itemm: Ticket)
    }
}