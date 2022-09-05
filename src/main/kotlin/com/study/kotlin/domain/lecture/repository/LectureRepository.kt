package com.study.kotlin.domain.lecture.repository

import com.study.kotlin.domain.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository: JpaRepository<Lecture, Long> {
    fun findLectureById(id: Long): Lecture?
}