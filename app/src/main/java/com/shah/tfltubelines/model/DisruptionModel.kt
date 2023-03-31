package com.shah.tfltubelines.model


import com.google.gson.annotations.SerializedName

data class DisruptionModel(
//    @SerializedName("affectedRoutes")
//    val affectedRoutes: List<AnyModel>,
//    @SerializedName("affectedStops")
//    val affectedStops: List<AnyModel>,
    @SerializedName("category")
    val category: String,
    @SerializedName("categoryDescription")
    val categoryDescription: String,
    @SerializedName("closureText")
    val closureText: String,
    @SerializedName("description")
    val description: String
)