package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.Lecture
import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.repository.LectureRepository
import com.study.kotlin.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository,
    private val memberRepository: MemberRepository
): LectureService {

    override fun registrationLecture(lectureRegistrationDto: LectureRegistrationDto) {
        val loginMember = memberRepository.findByNameAndPassword(lectureRegistrationDto.password, lectureRegistrationDto.name)
        lectureRepository.save(Lecture
        (
            title = lectureRegistrationDto.title,
            price = lectureRegistrationDto.price,
            category = lectureRegistrationDto.category,
            member = loginMember!!,
        ))

    }
}