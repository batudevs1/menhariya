package com.example.menhariya.repository

import com.example.menhariya.data.TransportEmb
import com.example.menhariya.data.TransportInfo
import com.example.menhariya.webservice.TransportInfoService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class TransportInfoRepo(private val transportService: TransportInfoService) {
    fun getAllInfo(): Deferred<Response<TransportEmb>> {
        return transportService.getAllInfo()
    }

    fun insertInfo(transportinfo: TransportInfo): Deferred<Response<Void>> {
        return transportService.insertInfo(transportinfo)
    }
   /* fun updateInfo(id: Long): Deferred<Response<Void>> {
        return transportService.updateInfo(id)
    }
*/
}