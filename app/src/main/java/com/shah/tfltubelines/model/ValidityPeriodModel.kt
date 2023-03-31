package com.shah.tfltubelines.model


import com.google.gson.annotations.SerializedName

data class ValidityPeriodModel(
    @SerializedName("fromDate")
    val fromDate: String,
    @SerializedName("isNow")
    val isNow: Boolean,
    @SerializedName("toDate")
    val toDate: String
)