package com.heeyjinny.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 알아두기... */
        //! : null값이 절대 될 수 없음
        //? : null값을 가질 수 있음

        //1
        //Layout뷰와 코틀린코드 파일 연결하기 - viewBinding없이 가져오기...
        //1-1
        //타입 선언을 하여 가져올 때 변수 다음 : EditText을 하여
        //findViewById가 타입에 맞는 것을 찾아오도록 함. 명시적 선언으로 가져오기
        val etHeight: EditText = findViewById(R.id.et_height)
        //1-2
        //타입 선언없이 가져올 때 <>에 타입을 추가하여
        //findViewById가 <>안의 타입을 반환하게 함. 추론적 선언으로 가져오기
        val etWeight = findViewById<EditText>(R.id.et_weight)
        val btnCheck = findViewById<Button>(R.id.btn_check)

        //2
        //버튼에 클릭을 받아오는 액션 추가
        //람다형식 setOnClickListener {  } 으로 추가하기
        btnCheck.setOnClickListener {
            //2-1
            //로그로 테스트해보기
            //Log.d("MainActivity","버튼이 클릭되었습니다.")

            //2-3
            //if문으로 에디트텍스트에 입력된 값이 빈 값이라면 경고창
            //빈 값이 아니라면 계산식 실행하기
            if (etHeight.text.isEmpty() || etWeight.text.isEmpty()){
                Toast.makeText(this,"체중 또는 신장을 모두 입력하세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //2-4
            //return을 사용하여 빈 값이 있을 때 다시 if문 실행으로 돌아가기 때문에
            //이 아래의 코드가 실행될 때는 절대 빈 값이 올 수 없음

            //2-1
            //에디드텍스트에 입력된 값 가져오기
            //Int형으로 텍스트 값 가져오기: .toString().toInt()
            val height: Int = etHeight.text.toString().toInt()
            val weight: Int = etWeight.text.toString().toInt()

            //2-2
            //로그창 확인해보기
            //Log.d("MainActivity", "신장: $height, 체중: $weight")

            //3
            //버튼 클릭 시 비만도 결과값을 얻기 위해 새 액티비티 생성하여 보여주기
            //java밑 패키지 우클릭 - New - Kotlin Class/File - ResultActivity생성

            //4
            //메인액티비티에서 result액티비티를 실행시키기 위해
            //인텐트 사용하기
            //두 가지 인자 넘겨주기: 현재액티비티, 다음으로 넘어갈 액티비티
            val intent = Intent(this, ResultActivity::class.java )
            startActivity(intent)
            //4-1
            //실행하여 확인 시 앱이 다운됨...
            //로그캣 창 확인: have you declared this activity in your AndroidManifest.xml?
            //AndroidManifest.xml안에 가지고 있는 액티비티를 추가해줘야함!!
        }

    }//onCreate
}//MainActivity