package com.example.menhariya.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/*@Entity (tableName = "users")*/

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
 data class User (
    val id: Long,
    val userid:String,
    val name:String,
    val bank:String,
    val password:String

 /*@PrimaryKey @ColumnInfo(name = "userid") val userid:String,
 @ColumnInfo(name = "name") val name:String,
 @ColumnInfo(name = "bank") val bank:String,
 @ColumnInfo(name = "password") val password:String,
 @ColumnInfo(name = "usertype") val usertype:String*/

)


