package com.study.kotlin.domain.member.service

import com.study.kotlin.domain.member.dto.MemberRegistrationDto

interface MemberService {
    fun registration(memberRegistrationDto: MemberRegistrationDto);
}