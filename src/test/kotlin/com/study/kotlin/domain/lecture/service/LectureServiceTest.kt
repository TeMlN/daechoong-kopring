package com.study.kotlin.domain.lecture.service

import com.study.kotlin.domain.lecture.Lecture
import com.study.kotlin.domain.lecture.dto.LectureRegistrationDto
import com.study.kotlin.domain.lecture.dto.PriceUpdateDto
import com.study.kotlin.domain.lecture.dto.TitleUpdateDto
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

    @Test
    @DisplayName("강의가 성공적으로 등록되나요?")
    fun registrationLectureTest() {
        makeMember()
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

    @Test
    @DisplayName("강의명 업데이트가 잘 되나요?")
    fun updateLectureTitleTest() {
        val lecture = makeLecture("실전!! 코틀린으로 REST API 만들기", 88000, LectureCategory.BACKEND)
        val oldTitle = lecture.title

        val titleUpdateDto = TitleUpdateDto("실전! Java에서 Kotlin 마이그레이션 하기")
        lecture.updateTitle(titleUpdateDto.title)

        Assertions.assertNotEquals(oldTitle, lecture.title)
    }

    @Test
    @DisplayName("강의비용이 업데이트가 잘 되나요?")
    fun updateLecturePriceTest() {
        val lecture = makeLecture("실전!! 코틀린으로 REST API 만들기", 88000, LectureCategory.BACKEND)
        val oldPrice = lecture.price

        val priceUpdateDto = PriceUpdateDto(120000)
        lecture.updatePrice(priceUpdateDto.price)

        Assertions.assertNotEquals(oldPrice, lecture.price)
    }

    @DisplayName("강의를 만들어주는 함수")
    fun makeLecture(title: String, price: Int, category: LectureCategory): Lecture {
        return lectureRepository.save(Lecture(
                title = title,
                price = price,
                category = category,
                member = makeMember()
        ))
    }

    @DisplayName("멤버를 만들어주는 함수")
    fun makeMember(): Member {
        return memberRepository.save(Member(
                name = "김태민",
                password = "1234"
        ))
    }
}