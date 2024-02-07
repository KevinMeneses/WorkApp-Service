package com.meneses.workAppService.jobOffers

import com.meneses.workAppService.jobOffers.dto.AcceptJobDTO
import com.meneses.workAppService.jobOffers.dto.JobDTO
import com.meneses.workAppService.repository.city.City
import com.meneses.workAppService.repository.job.Job
import com.meneses.workAppService.repository.job.JobRepository

class JobOffersService(
    private val jobRepository: JobRepository = JobRepository()
) {
    fun getJobOffersInMyCity(city: String) =
        jobRepository.findJobOffersByCity(city)

    fun createJobOffer(jobDTO: JobDTO): Boolean {
        val job = Job(
            title = jobDTO.title,
            description = jobDTO.description,
            salary = jobDTO.salary,
            city = City.valueOf(jobDTO.city),
            latitude = jobDTO.latitude,
            longitude = jobDTO.longitude,
            status = Job.Status.OFFERED,
            contractorId = jobDTO.contractorId
        )

        return jobRepository.saveJob(job)
    }

    fun acceptJobOffer(acceptJobDTO: AcceptJobDTO): Boolean {
        val jobOffer = jobRepository
            .findJobOfferById(acceptJobDTO.jobId)
            ?: throw RuntimeException("The Job to accept does not exist")

        if (jobOffer.status != Job.Status.OFFERED)
            throw RuntimeException("The Job is not in offer anymore")

        val updatedJob = jobOffer.copy(
            workerId = acceptJobDTO.workerId,
            status = Job.Status.ACCEPTED
        )

        return jobRepository.updateJob(updatedJob)
    }
}