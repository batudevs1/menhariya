package com.example.menhariya.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DriverEmb( @SerializedName("_embedded")
                @Expose
                val embeddedUsers: UserList
) {

    data class UserList(
        @SerializedName("drivers")
        @Expose
        val allDrivers: List<Driver>
    )

}