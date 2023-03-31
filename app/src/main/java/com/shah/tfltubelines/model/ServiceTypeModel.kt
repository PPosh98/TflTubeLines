package com.shah.tfltubelines.model


import com.google.gson.annotations.SerializedName

data class ServiceTypeModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("uri")
    val uri: String
)