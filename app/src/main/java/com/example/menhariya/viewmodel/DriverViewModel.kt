package com.example.menhariya.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.menhariya.data.Driver
import com.example.menhariya.data.DriverEmb
import com.example.menhariya.data.User
import com.example.menhariya.data.UsersEmb
import com.example.menhariya.repository.DriverRepository
import com.example.menhariya.repository.UserRepository
import com.example.menhariya.webservice.DriverWebService
import com.example.menhariya.webservice.ServiceBuilder
import com.example.menhariya.webservice.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class DriverViewModel(application: Application): AndroidViewModel(application) {

    private val driverRepository: DriverRepository

    init {
        val driverService = ServiceBuilder.buildService(DriverWebService::class.java)
        driverRepository = DriverRepository(driverService)
    }

    fun getAllDrivers(): LiveData<List<Driver>> {
        val allDrivers: MutableLiveData<List<Driver>> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<DriverEmb> = driverRepository.getAllDrivers().await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    allDrivers.value = responseBody.embeddedUsers.allDrivers
                }
            }

        }

        return allDrivers
    }

    fun getDriverById(id: Long): LiveData<Driver> {
        val driver: MutableLiveData<Driver> = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Driver> = driverRepository.getDriverById(id).await()
            val responseBody = response.body()
            if(responseBody != null) {
                withContext(Dispatchers.Main) {
                    driver.value = responseBody
                }
            }

        }

        return driver
    }

    fun newDriver(driver: Driver) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = driverRepository.addDriver(driver).await()

        }
    }
}