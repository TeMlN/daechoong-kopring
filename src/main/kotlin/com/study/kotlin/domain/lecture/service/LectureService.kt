package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto

interface LectureService {
    fun registrationLecture(lectureRegistrationDto: LectureRegistrationDto)
}