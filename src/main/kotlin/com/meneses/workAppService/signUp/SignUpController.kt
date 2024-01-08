package com.meneses.workAppService.signUp

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/signup")
class SignUpController(
    private val signUpService: SignUpService = SignUpService()
) {
    @PostMapping("/register")
    fun register(@RequestBody signUpDTO: SignUpDTO) =
        signUpService.register(signUpDTO)
}