package com.example.menhariya.repository

import com.example.menhariya.data.BankAccount
import com.example.menhariya.data.BankEmb
import com.example.menhariya.webservice.BankAccountService

import kotlinx.coroutines.Deferred
import retrofit2.Response

class AccountRepo(private val bankAccountService: BankAccountService)  {


    fun getAllAccount(): Deferred<Response<BankEmb>> {
        return bankAccountService.getAllAccount()
    }



    fun insertAccount(bancacc: BankAccount): Deferred<Response<Void>> {
        return bankAccountService.insertAccount(bancacc)
    }





}