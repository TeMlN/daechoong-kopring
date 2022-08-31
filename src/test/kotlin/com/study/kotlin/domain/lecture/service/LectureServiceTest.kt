package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.enumType.LectureCategory
import com.study.kotlin.domain.lecture.repository.LectureRepository
import com.study.kotlin.domain.member.Member
import com.study.kotlin.domain.member.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class LectureServiceTest(
    @Autowired private val lectureService: LectureService,
    @Autowired private val lectureRepository: LectureRepository,
    @Autowired private val memberRepository: MemberRepository,
) {

    @BeforeEach
    @DisplayName("Test가 실행되기 전 Test에 사용될 유저를 회원가입 시킴")
    fun registerMember() {
        memberRepository.save(Member(
                name = "김태민",
                password = "1234"
        ))
    }

    @Test
    @DisplayName("강의가 성공적으로 등록되나요?")
    fun registrationLectureTest() {
        val lectureRegistrationDto = LectureRegistrationDto(
                name = "김태민",
                password = "1234",
                title = "실전! Kotlin REST API 설계하기",
                price = 88000,
                category = LectureCategory.BACKEND,
        )

        lectureService.registrationLecture(lectureRegistrationDto)

        Assertions.assertEquals(lectureRepository.count(), 1)
    }
}