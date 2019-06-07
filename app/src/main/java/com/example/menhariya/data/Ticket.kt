package com.example.menhariya.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ticket")
data class Ticket (
    @PrimaryKey
    @ColumnInfo(name = "carplate")
    val carplate: String,
    @ColumnInfo(name = "start")
    val start: String,
    @ColumnInfo(name = "destination")
    val destination: String,
    @ColumnInfo(name = "cartype")
    val cartype: String,
    @ColumnInfo(name = "chairno")
    val chairno: String,
    @ColumnInfo(name = "driverid")
    val driverid: String

    ): Serializable