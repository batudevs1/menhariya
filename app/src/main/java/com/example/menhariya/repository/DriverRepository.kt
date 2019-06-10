package com.example.menhariya.repository

import com.example.busstation.DriverProfile
import com.example.menhariya.data.Driver
import com.example.menhariya.data.DriverEmb
import com.example.menhariya.data.User
import com.example.menhariya.data.UsersEmb
import com.example.menhariya.webservice.DriverWebService
import com.example.menhariya.webservice.UserService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class DriverRepository(private val driverService: DriverWebService) {

    fun getAllDrivers(): Deferred<Response<DriverEmb>> {
        return driverService.getDrivers()
    }

    fun getDriverById(id: Long): Deferred<Response<Driver>> {
        return driverService.getDriverById(id)
    }

    fun addDriver(driver: Driver): Deferred<Response<Void>> {
        return driverService.createDriver(driver)
    }
}