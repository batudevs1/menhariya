package com.example.menhariya.repository

import com.example.menhariya.data.Ticket
import com.example.menhariya.data.TicketEmb
import com.example.menhariya.webservice.TicketService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class TicketRepository(private val ticketService: TicketService) {

    fun getAllTickets(): Deferred<Response<TicketEmb>> {
        return ticketService.getTickets()
    }

    fun getTicketById(id: Long): Deferred<Response<Ticket>> {
        return ticketService.getTicket(id)
    }

    fun addTicket(ticket: Ticket): Deferred<Response<Void>> {
        return ticketService.createTicket(ticket)
    }

    fun deleteTicket(id: Long): Deferred<Response<Void>> {
        return ticketService.deleteTicket(id)
    }

}