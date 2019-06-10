package com.example.menhariya.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.menhariya.data.User
import com.example.menhariya.data.UsersEmb
import com.example.menhariya.repository.UserRepository
import com.example.menhariya.webservice.ServiceBuilder
import com.example.menhariya.webservice.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val userRepository: UserRepository

    init {
        val userService = ServiceBuilder.buildService(UserService::class.java)
        userRepository = UserRepository(userService)
    }

    fun getAllUsers(): LiveData<List<User>> {
        val allUsers: MutableLiveData<List<User>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<UsersEmb> = userRepository.getAllUsers().await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    allUsers.value = responseBody.embeddedUsers.allUsers
                }
            }

        }

        return allUsers
    }

    fun getUserById(id: Long): LiveData<User> {
        val user: MutableLiveData<User> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<User> = userRepository.getUserById(id).await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    user.value = responseBody
                }
            }

        }

        return user
    }

    fun newUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = userRepository.addUser(user).await()

        }
    }
}

