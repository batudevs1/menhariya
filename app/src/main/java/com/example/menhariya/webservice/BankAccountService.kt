package com.example.menhariya.webservice

import com.example.menhariya.data.BankAccount
import com.example.menhariya.data.BankEmb
import com.example.menhariya.data.Driver
import com.example.menhariya.data.DriverEmb
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface BankAccountService {

    @GET("bankacc")
    fun getAllAccount(): Deferred<Response<BankEmb>>

    @DELETE("bancacc/id")
    fun deleteAccount(@Path("id") id: Long): Deferred<Response<Void>>

    @POST("bankacc")
    fun insertAccount(@Body newbankacc: BankAccount): Deferred<Response<Void>>


}