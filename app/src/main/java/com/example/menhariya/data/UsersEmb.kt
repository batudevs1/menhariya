package com.example.menhariya.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersEmb( @SerializedName("_embedded")
@Expose
val embeddedUsers: UserList
) {

    data class UserList(
        @SerializedName("users")
        @Expose
        val allUsers: List<User>
    )

}