package com.meneses.workAppService.assignedJobs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assigned_jobs")
class AssignedJobsController(
    private val assignedJobsService: AssignedJobsService = AssignedJobsService()
) {
    @GetMapping("/all_jobs")
    fun getAllUserJobs(
        @RequestParam("user_id", required = true) userId: String
    ) = assignedJobsService.getAllUserJobs(userId)

    @GetMapping("/accepted_jobs")
    fun getUserAcceptedJobs(
        @RequestParam("user_id", required = true) userId: String
    ) = assignedJobsService.getUserAcceptedJobs(userId)

    @GetMapping("/in_progress_jobs")
    fun getUserInProgressJobs(
        @RequestParam("user_id", required = true) userId: String
    ) = assignedJobsService.getUserInProgressJobs(userId)

    @PutMapping("/start")
    fun startJobs(
        @RequestBody(required = true) startJobDTO: StartJobDTO
    ) = assignedJobsService.startJobs(startJobDTO)
}