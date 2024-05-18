package com.meneses.workAppService.users

import com.meneses.workAppService.users.dto.UserDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userProfileService: UserProfileService = UserProfileService()
) {
    @GetMapping("/profile")
    fun getUserProfile(
        @RequestParam("user_id", required = true) userId: String
    ) = userProfileService.getUserProfile(userId)

    @PutMapping("/profile")
    fun updateUserProfile(
        @RequestBody(required = true) userDTO: UserDTO
    ) = userProfileService.updateUserProfile(userDTO)
}