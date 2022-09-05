package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.Lecture
import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.dto.PriceUpdateDto
import com.study.kotlin.domain.lecture.dto.TitleUpdateDto
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

    override fun updateLectureTitle(lectureId: Long, titleUpdateDto: TitleUpdateDto) {
        val findLecture = lectureRepository.findLectureById(lectureId)
                ?: throw IllegalArgumentException("강의가 존재하지 않습니다.")

        findLecture.updateTitle(titleUpdateDto.title)

    }

    override fun updateLecturePrice(lectureId: Long, priceUpdateDto: PriceUpdateDto) {
        val findLecture = lectureRepository.findLectureById(lectureId)
                ?: throw IllegalArgumentException("강의가 존재하지 않습니다.")

        findLecture.updatePrice(priceUpdateDto.price)
    }
}