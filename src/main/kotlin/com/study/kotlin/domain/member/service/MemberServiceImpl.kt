package com.study.kotlin.domain.member.service

import com.study.kotlin.domain.member.Member
import com.study.kotlin.domain.member.dto.MemberRegistrationDto
import com.study.kotlin.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository
): MemberService {

    override fun registration(memberRegistrationDto: MemberRegistrationDto) {
        val member = Member(
            name = memberRegistrationDto.name
        )
        memberRepository.save(member);
    }

}