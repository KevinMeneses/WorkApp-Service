package com.meneses.workAppService.assignedJobs

import com.meneses.workAppService.repository.job.Job
import com.meneses.workAppService.repository.job.JobRepository

class AssignedJobsService(
    private val jobRepository: JobRepository = JobRepository()
) {
    fun getAllUserJobs(userId: String) =
        jobRepository.findAllJobsByUserId(userId)

    fun getUserAcceptedJobs(userId: String) =
        jobRepository.findUserJobsByStatus(
            userId = userId,
            status = Job.Status.ACCEPTED.name
        )

    fun getUserInProgressJobs(userId: String) =
        jobRepository.findUserJobsByStatus(
            userId = userId,
            status = Job.Status.IN_PROGRESS.name
        )

    fun startJob(updateJobStatusDTO: UpdateJobStatusDTO) : Boolean {
        val startJob = jobRepository
            .findJobByIdAndWorkerId(
                jobId = updateJobStatusDTO.jobId,
                workerId = updateJobStatusDTO.workerId
            )
            ?: throw RuntimeException("The job does not exist")

        if (startJob.status != Job.Status.ACCEPTED)
            throw RuntimeException("The job cannot be start")

        val updatedJob = startJob.copy(
            status = Job.Status.IN_PROGRESS
        )

        return jobRepository.updateJob(updatedJob)
    }

    fun finishJob(updateJobStatusDTO: UpdateJobStatusDTO): Boolean {
        val finishJob = jobRepository
            .findJobByIdAndWorkerId(
                jobId = updateJobStatusDTO.jobId,
                workerId = updateJobStatusDTO.workerId
            )
            ?: throw RuntimeException("The job does not exist")

        if (finishJob.status != Job.Status.IN_PROGRESS)
            throw RuntimeException("The job cannot be finished")

        val updatedJob = finishJob.copy(
            status = Job.Status.FINISHED
        )

        return jobRepository.updateJob(updatedJob)
    }
}