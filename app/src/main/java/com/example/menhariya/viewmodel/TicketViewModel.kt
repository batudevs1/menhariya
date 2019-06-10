package com.example.menhariya.viewmodel

import android.app.Application
import android.content.ClipData
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.menhariya.data.Ticket
import com.example.menhariya.data.TicketEmb
import com.example.menhariya.repository.TicketRepository
import com.example.menhariya.webservice.ServiceBuilder
import com.example.menhariya.webservice.TicketService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class TicketViewModel(application: Application): AndroidViewModel(application)  {

    private val ticketRepository: TicketRepository

    init {
        val ticketService = ServiceBuilder.buildService(TicketService::class.java)
        ticketRepository = TicketRepository(ticketService)
    }

    fun getAllTickets(): LiveData<List<Ticket>> {
        val allTickets: MutableLiveData<List<Ticket>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<TicketEmb> = ticketRepository.getAllTickets().await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    allTickets.value = responseBody.embTicket.allTicket
                }
            }

        }



        return allTickets

    }

    fun getTicketById(id: Long): LiveData<Ticket> {
        val ticket: MutableLiveData<Ticket> = MutableLiveData()


        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Ticket> = ticketRepository.getTicketById(id).await()
            val  responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main){
                    ticket.value = response.body()
                }
            }
        }

        return ticket
    }


    fun addTicket(ticket: Ticket) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = ticketRepository.addTicket(ticket).await()
            Log.d("ticket added", response.message())
        }
    }

    fun deleteTicket(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = ticketRepository.deleteTicket(id).await()
            Log.d("deleted", response.message())
        }
    }


}