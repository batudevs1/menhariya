package com.example.menhariya.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransportInfo (
    val start_pos:String,
    val dest_pos:String,
    val tranport_date:String,
    val tranport_time:String,
    val driver_id:String
)

