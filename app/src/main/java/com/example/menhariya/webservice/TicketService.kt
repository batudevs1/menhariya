package com.example.menhariya.webservice

import com.example.menhariya.data.Ticket
import com.example.menhariya.data.TicketEmb
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface TicketService {
    @GET("ticket")
    fun getTickets(): Deferred<Response<TicketEmb>>

    @GET("ticket/{id}")
    fun getTicket(@Path("id") id: Long): Deferred<Response<Ticket>>

    @POST("ticket")
    fun createTicket(@Body newTicket: Ticket): Deferred<Response<Void>>

    @FormUrlEncoded
    @PUT("ticket/id")
    fun updateTicket(
        @Path("id") id: Int,
        @Field("car_plate") car_plate: String,
        @Field("start") start: String,
        @Field("destination") destination: String,
        @Field("cartype") cartype: String,
        @Field("chairno") chairno: Int,
        @Field("driverid") driverid: String,
        @Field("date") date: Date
    ): Deferred<Response<Void>>

    @DELETE("ticket/id")
    fun deleteTicket(@Path("id") id: Long): Deferred<Response<Void>>

}