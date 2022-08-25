package com.study.kotlin.domain.member.service

import com.study.kotlin.domain.member.dto.MemberRegistrationDto
import com.study.kotlin.domain.member.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest(
    @Autowired private val memberService: MemberService,
    @Autowired private val memberRepository: MemberRepository
) {

    @Test
    fun registrationTest() {
        val memberRegistrationDto = MemberRegistrationDto(
                name = "김태민"
        )
        memberService.registration(memberRegistrationDto)

        Assertions.assertEquals(1, memberRepository.count())
    }
}