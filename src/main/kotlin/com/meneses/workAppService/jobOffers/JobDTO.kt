package com.meneses.workAppService.jobOffers


data class JobDTO(
    val contractorId: String,
    val title: String,
    val description: String,
    val salary: Double,
    val city: String,
    val latitude: Double,
    val longitude: Double
)
