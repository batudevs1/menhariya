package com.example.menhariya.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BankEmb( @SerializedName("_embedded")
                @Expose
                val embeddedBank: BankList
) {

    data class BankList(
        @SerializedName("bankacc")
        @Expose
        val allUsers: List<BankAccount>
    )

}