package com.meneses.workAppService.jobOffers

import com.meneses.workAppService.jobOffers.dto.AcceptJobDTO
import com.meneses.workAppService.jobOffers.dto.JobDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("jobs_offers")
class JobOffersController(
    private val jobOffersService: JobOffersService = JobOffersService()
) {
    @GetMapping("/in_my_city")
    fun getJobOffersInMyCity(
        @RequestParam("city", required = true) city: String
    ) = jobOffersService.getJobOffersInMyCity(city)

    @PostMapping("/create")
    fun createJobOffer(
        @RequestBody(required = true) jobDTO: JobDTO
    ) = jobOffersService.createJobOffer(jobDTO)

    @PutMapping("/accept")
    fun acceptJobOffer(
        @RequestBody(required = true) acceptJobDTO: AcceptJobDTO
    ) = jobOffersService.acceptJobOffer(acceptJobDTO)

    @DeleteMapping("/delete")
    fun deleteJob(
        @RequestParam("jobId", required = true) jobId: String
    ) =jobOffersService.deleteJob(jobId)
}