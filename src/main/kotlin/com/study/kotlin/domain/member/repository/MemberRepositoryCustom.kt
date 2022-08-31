package com.study.kotlin.domain.member.repository

import com.study.kotlin.domain.member.Member


interface MemberRepositoryCustom {
    fun findByNameAndPassword(password: String, name: String): Member?
}