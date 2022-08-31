package com.study.kotlin.domain.member.repository

import com.study.kotlin.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, Long>, MemberRepositoryCustom {
}