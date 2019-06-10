package com.example.menhariya.data
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data  class Driver (

    val id: Long,
    val userid:String,
    val name:String,
    val bank:String,
    val password:String


)
