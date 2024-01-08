package com.meneses.workAppService.jobOffers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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
}