package com.example.menhariya.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*


data class Ticket (
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("car_plate")
    @Expose
    val car_plate: String,

    @SerializedName("start")
    @Expose
    val start: String,

    @SerializedName("destination")
    @Expose
    val destination: String,

    @SerializedName("cartype")
    @Expose
    val cartype: String,

    @SerializedName("price")
    @Expose
    val price: String,

    @SerializedName("chairno")
    @Expose
    val chairno: String,
    @SerializedName("driverid")
    @Expose
    val driverid: String,
    @SerializedName("date")
    @Expose
    val date: String

    ): Serializable