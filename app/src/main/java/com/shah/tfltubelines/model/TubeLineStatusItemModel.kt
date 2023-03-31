package com.shah.tfltubelines.model


import com.google.gson.annotations.SerializedName

data class TubeLineStatusItemModel(
    @SerializedName("created")
    val created: String,
//    @SerializedName("disruptions")
//    val disruptions: List<AnyModel>,
    @SerializedName("id")
    val id: String,
    @SerializedName("lineStatuses")
    val lineStatuses: List<LineStatuseModel>,
    @SerializedName("modeName")
    val modeName: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
//    @SerializedName("routeSections")
//    val routeSections: List<AnyModel>,
    @SerializedName("serviceTypes")
    val serviceTypes: List<ServiceTypeModel>
)