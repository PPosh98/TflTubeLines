package com.shah.tfltubelines.model


import com.google.gson.annotations.SerializedName

data class LineStatuseModel(
    @SerializedName("created")
    val created: String,
    @SerializedName("disruption")
    val disruption: DisruptionModel,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lineId")
    val lineId: String,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("statusSeverity")
    val statusSeverity: Int,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String,
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriodModel>
)