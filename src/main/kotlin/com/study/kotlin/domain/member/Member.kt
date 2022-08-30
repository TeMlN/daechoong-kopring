package com.study.kotlin.domain.member

import javax.persistence.*

@Entity(name = "member")
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null,

    @Column(name = "member_name", unique = true)
    val name: String,

    @Column(name = "member_password")
    val password: String
) {
}