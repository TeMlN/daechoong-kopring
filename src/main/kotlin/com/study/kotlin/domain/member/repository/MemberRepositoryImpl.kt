package com.study.kotlin.domain.member.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.kotlin.domain.member.Member
import com.study.kotlin.domain.member.QMember.*
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): MemberRepositoryCustom {

    override fun findByNameAndPassword(password: String, name: String): Member? {
         return jpaQueryFactory.query()
                .from(member)
                .select(member)
                .where(member.password.eq(password)
                        .and(member.name.eq(name))
                ).fetchOne()
    }
}