package com.study.kotlin.domain.member.controller

import com.study.kotlin.domain.member.dto.MemberRegistrationDto
import com.study.kotlin.domain.member.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/member/registration")
    @ResponseStatus(HttpStatus.CREATED)
    private fun registration(
        @RequestBody memberRegistrationDto: MemberRegistrationDto
    ) {
        memberService.registration(memberRegistrationDto)
    }
}