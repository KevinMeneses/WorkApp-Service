package com.meneses.workAppService.repository.job

import com.meneses.workAppService.repository.city.City

class JobRepository {
    fun findJobOffersByCity(city: String) =
        jobs.filter { it.city == City.valueOf(city) && it.status == Job.Status.OFFERED }

    fun findAllJobsByUserId(userId: String) =
        jobs.filter { it.workerId == userId }

    fun findUserJobsByStatus(userId: String, status: String) =
        jobs.filter { it.workerId == userId && it.status == Job.Status.valueOf(status) }

    fun saveJob(job: Job) = jobs.add(job)

    fun findJobOfferById(jobId: String) =
        jobs.find { it.id == jobId }

    fun findJobByIdAndWorkerId(jobId: String, workerId: String) =
        jobs.find { it.id== jobId && it.workerId == workerId }

    fun updateJob(updatedJob: Job): Boolean {
        val index = jobs.indexOfFirst { it.id == updatedJob.id }
        return try {
            jobs[index] = updatedJob
            true
        } catch (_: Exception) {
            false
        }
    }

    private companion object {
        val jobs = mutableListOf(
            Job(
                id = "0",
                title = "Something",
                description = "Easy pizzy",
                salary = 50_000.0,
                city = City.POPAYAN,
                latitude = 123.0,
                longitude = 123.9,
                status = Job.Status.OFFERED,
                contractorId = "0"
            ),
            Job(
                id = "1",
                title = "Something 2",
                description = "Hard :(",
                salary = 100_000.0,
                city = City.POPAYAN,
                latitude = 163.23,
                longitude = 183.89,
                status = Job.Status.OFFERED,
                contractorId = "1"
            ),
            Job(
                id = "2",
                title = "Something 3",
                description = "Hard :(",
                salary = 100_000.0,
                city = City.POPAYAN,
                latitude = 163.23,
                longitude = 183.89,
                status = Job.Status.IN_PROGRESS,
                contractorId = "2",
                workerId = "2"
            ),
            Job(
                id = "3",
                title = "Something 3",
                description = "Hard :(",
                salary = 100_000.0,
                city = City.POPAYAN,
                latitude = 163.23,
                longitude = 183.89,
                status = Job.Status.ACCEPTED,
                contractorId = "2",
                workerId = "0"
            ),
        )
    }
}