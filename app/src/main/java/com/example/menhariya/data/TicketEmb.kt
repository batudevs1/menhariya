package com.example.menhariya.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TicketEmb(

    @SerializedName("_embedded")
    @Expose
    val embTicket: TicketList
) {

    data class TicketList(
        @SerializedName("ticket")
        @Expose
        val allTicket: List<Ticket>
    )

}
