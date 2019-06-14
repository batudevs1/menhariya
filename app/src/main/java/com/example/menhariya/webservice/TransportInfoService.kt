package com.example.menhariya.webservice

import com.example.menhariya.data.TransportEmb
import com.example.menhariya.data.TransportInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface TransportInfoService {
    @GET("transportinfo")
    fun getAllInfo(): Deferred<Response<TransportEmb>>


    @POST("transportinfo")
    fun insertInfo(@Body transportInfo: TransportInfo): Deferred<Response<Void>>

    @FormUrlEncoded
    @PUT("transportinfo/id")
    fun updateInfo(
        @Path("id") id: Long,
        @Field("start_pos") startpos: String,
        @Field("dest_pos") destpos: String,
        @Field("transport_date") transportdate: String,
        @Field("transport_date") transporttime: String,
        @Field("driver_id") driverid:String
    ): Deferred<Response<Void>>
}

