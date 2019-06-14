package com.example.menhariya.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TransportEmb( @SerializedName("_embedded")
               @Expose
               val embeddedInfo: TransportInfoList
) {

    data class TransportInfoList(
        @SerializedName("transportinfo")
        @Expose
        val allUsers: List<BankAccount>
    )

}