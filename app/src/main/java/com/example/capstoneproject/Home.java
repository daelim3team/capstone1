package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button registration;
    ImageView imgv_mypage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        registration = findViewById(R.id.button3);
        imgv_mypage = findViewById(R.id.imageView5);



        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Home.this,Register_Search_1.class);
                //하위 코드 실행을 위한 입시 주석
                //startActivity(intent);

                //임시 동적 뷰
                for (int i = 0; i <= 3; i++) { //테스트용 반복문 (없어도 됨)
                    dynamic_Home_view n_dynamicHomeview = new dynamic_Home_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기
                    LinearLayout con = (LinearLayout) findViewById(R.id.scrollview_Linear); //추가할 레이아웃 위치
                    con.addView(n_dynamicHomeview);    //add View로 추가 명령
                }

                //임시 동적 뷰 코드 끝
            }
        });

        imgv_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Mypage.class);
                Toast.makeText(Home.this, "이미지 뷰 클릭", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }
}
