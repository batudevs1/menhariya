package com.example.menhariya.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class BankAccount (
    val id:Long,
    val acc_no:String,
    val password:String,
    val balance:Float

)

