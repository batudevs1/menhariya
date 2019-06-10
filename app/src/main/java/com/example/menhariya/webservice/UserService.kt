package com.example.menhariya.webservice

import com.example.menhariya.data.User
import com.example.menhariya.data.UsersEmb
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface UserService {
    @GET("users")
    fun getUsers(): Deferred<Response<UsersEmb>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Long): Deferred<Response<User>>

    @POST("users")
    fun createUser(@Body newUser: User): Deferred<Response<Void>>

    @FormUrlEncoded
    @PUT("users/id")
    fun updateUser(
        @Path("id") id: Long,
        @Field("userid") user_name: String,
        @Field("name") phone_number: String,
        @Field("bank") address: String,
        @Field("password") password: String
    ): Deferred<Response<Void>>

}