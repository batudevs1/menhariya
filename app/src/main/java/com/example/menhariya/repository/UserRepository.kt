package com.example.menhariya.repository

import com.example.menhariya.data.User
import com.example.menhariya.data.UsersEmb
import com.example.menhariya.webservice.UserService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class UserRepository(private val userService: UserService) {

    fun getAllUsers(): Deferred<Response<UsersEmb>> {
        return userService.getUsers()
    }

    fun getUserById(id: Long): Deferred<Response<User>> {
        return userService.getUserById(id)
    }

    fun addUser(user: User): Deferred<Response<Void>> {
        return userService.createUser(user)
    }

}