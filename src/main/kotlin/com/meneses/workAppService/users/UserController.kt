package com.meneses.workAppService.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userProfileService: UserProfileService = UserProfileService()
) {
    @GetMapping("/profile")
    fun getUserProfile(
        @RequestParam("user_id", required = true) userId: String
    ) = userProfileService.getUserProfile(userId)
}