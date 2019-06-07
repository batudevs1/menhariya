package com.example.menhariya.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "users")
 data class User (
 @PrimaryKey @ColumnInfo(name = "userid") val userid:String,
 @ColumnInfo(name = "name") val name:String,
 @ColumnInfo(name = "bank") val bank:Int,
 @ColumnInfo(name = "password") val password:String,
 @ColumnInfo(name = "usertype") val usertype:String

):Serializable