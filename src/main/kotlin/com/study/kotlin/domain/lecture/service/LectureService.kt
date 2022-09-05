package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.dto.PriceUpdateDto
import com.study.kotlin.domain.lecture.dto.TitleUpdateDto

interface LectureService {
    fun registrationLecture(lectureRegistrationDto: LectureRegistrationDto)
    fun updateLectureTitle(lectureId: Long, titleUpdateDto: TitleUpdateDto)
    fun updateLecturePrice(lectureId: Long, priceUpdateDto: PriceUpdateDto)
}