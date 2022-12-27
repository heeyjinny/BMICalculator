package com.heeyjinny.bmicalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

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

        //4
        //인텐트로 넘겨받은 값 가져오기
        val height = intent.getDoubleExtra("height", 0.0)
        val weight = intent.getDoubleExtra("weight", 0.0)
        //Log.d("result", "신장: $height, 체중: $weight")

        //5
        //BMI계산 = 체중 / 키의제곱(키는 cm로받음)
        //BMI계산 시 키는 m로 계산하기 때문에 받은 키의 값을 m로 변환해줘야 함(키/100)
        //제곱근 구하는 메서드 Math.pow()사용, 더블형만 사용하기 때문에 실수로 변경(.0)
        //Math.pow()는 자바방식 -> (height / 100.0).pow(2.0)는 코틀린방식
        val bmi = weight / (height / 100.0).pow(2.0)

        //6
        //BMI계산 값에 따라 텍스트설정
        val resultText = when{
            bmi >=35.0 -> "\'고도비만\'"
            bmi >=30.0 -> "\'중정도비만\'"
            bmi >=25.0 -> "\'경도비만\'"
            bmi >=23.0 -> "\'과체중\'"
            bmi >=18.5 -> "\'정상체중\'"
            else -> "\'저체중\'"
        }

        //7
        //activity_result.xml 작성하고
        //위젯 연결
        val resultValueTextView = findViewById<TextView>(R.id.resultValueTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultStringTextView)
        val resultIconTextView = findViewById<TextView>(R.id.resultIconTextView)
        val btnReCheck = findViewById<Button>(R.id.btn_recheck)

        //9
        //아이콘 반영
        when (resultText) {
            "\'저체중\'" -> resultIconTextView.text = "😞"
            "\'정상체중\'" -> resultIconTextView.text = "😊"
            "\'고도비만\'" -> resultIconTextView.text = "🤢"
            else -> resultIconTextView.text = "😲"
        }

        //8
        //결과 값 반영하기
        //BMI결과 값은 반올림하여 소수점 둘째자리까지 나타냄
        //String.format("%.2f", 변수) 사용하며 리턴값이 String이므로 문자열 변환 필요x
        resultValueTextView.text = String.format("%.2f", bmi)
        resultStringTextView.text = resultText

        //10
        //다시 확인하기 버튼 클릭 이벤트
        btnReCheck.setOnClickListener {
            onBackPressed()
            finish()
        }

    }//onCreate
}//ResultActivity