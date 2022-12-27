package com.heeyjinny.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//1
//AppCompatActivity()를 상속받는 클래스로 만들기
//2
//ResultActivity파일과 연결할 layout 파일도 생성
//res - layout우클릭 - New - Layout Resource File - activity_result

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //3
        //layout파일과 코틀린파일 연결하기
        setContentView(R.layout.activity_result)


    }//onCreate
}//ResultActivity