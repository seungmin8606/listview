package com.example.listview

import java.io.Serializable

class Room( // 클래스의 생성자에서 변수들을 나열해서 클래스가 가져야하는 정보 항목들로 설정
    val companyKR: String,
    val companyEN: String,
    val wineName: String,
    val price: Int,
    val wineEN: String
) : Serializable {

}