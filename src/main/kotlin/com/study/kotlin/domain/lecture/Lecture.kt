package com.study.kotlin.domain.lecture

import com.study.kotlin.domain.lecture.enumType.LectureCategory
import com.study.kotlin.domain.member.Member
import javax.persistence.*

@Entity(name = "lecture")
class Lecture(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "lecture_category")
    var category: LectureCategory,

    @Column(name = "lecture_title")
    var title: String,

    @Column(name = "lecture_price")
    var price: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member,

) {
    fun updatePrice(price: Int) {
        this.price = price
    }

    fun updateTitle(title: String) {
        this.title = title
    }
}