package com.study.kotlin.domain.lecture.controller

import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.service.LectureService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class LectureController(
    private val lectureService: LectureService
) {

    @PostMapping("/registration/lecture")
    fun registrationLecture(
        @RequestBody lectureRegistrationDto: LectureRegistrationDto
    ) {
        lectureService.registrationLecture(lectureRegistrationDto)
    }
}