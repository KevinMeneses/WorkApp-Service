package com.meneses.workAppService.jobOffers

import com.meneses.workAppService.repository.city.City
import com.meneses.workAppService.repository.job.Job
import com.meneses.workAppService.repository.job.JobRepository

class JobOffersService(
    private val jobRepository: JobRepository = JobRepository(),
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
}