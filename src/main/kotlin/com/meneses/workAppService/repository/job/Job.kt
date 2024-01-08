package com.meneses.workAppService.repository.job

import com.meneses.workAppService.repository.city.City

data class Job(
    val id: String? = null,
    val title: String,
    val description: String,
    val salary: Double,
    val city: City,
    val latitude: Double,
    val longitude: Double,
    val status: Status,
    val contractorId: String,
    val workerId: String? = null
) {
    enum class Status {
        OFFERED,
        ACCEPTED,
        IN_PROGRESS,
        FINISHED
    }
}
