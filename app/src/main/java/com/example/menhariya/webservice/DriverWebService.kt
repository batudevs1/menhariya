package com.example.menhariya.webservice

import com.example.menhariya.data.Driver
import com.example.menhariya.data.DriverEmb
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface DriverWebService {
    @GET("drivers")
    fun getDrivers(): Deferred<Response<DriverEmb>>

    @GET("drivers/{id}")
    fun getDriverById(@Path("id") id: Long): Deferred<Response<Driver>>

    @POST("drivers")
    fun createDriver(@Body newDriver: Driver): Deferred<Response<Void>>

    @FormUrlEncoded
    @PUT("drivers/id")
    fun updateDriver(
        @Path("id") id: Long,
        @Field("driverid") driver_name: String,
        @Field("name") phone_number: String,
        @Field("bank") address: String,
        @Field("password") password: String
    ): Deferred<Response<Void>>
}