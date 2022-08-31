package com.study.kotlin.domain.lecture.dto

import com.study.kotlin.domain.lecture.enumType.LectureCategory

data class LectureRegistrationDto(
    val name: String,
    val password: String,
    val category: LectureCategory,
    val price: Int,
    val title: String
) {
}
