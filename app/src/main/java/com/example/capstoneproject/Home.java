package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.format.TextStyle;

public class Home extends AppCompatActivity {
    Button registration;
    ImageView imgv_mypage;
    TextView TempTextView;

    public void Declaration()
    {
        setContentView(R.layout.activity_home);

        registration = findViewById(R.id.button3);
        imgv_mypage = findViewById(R.id.imageView5);

        TempTextView = findViewById(R.id.textView8);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Declaration();

        Product_save_list save_list = new Product_save_list();

        for (int i = 0; i <= save_list.export_product_name.length; i++) { //배열의 크기만큼 생성
//            if(save_list.export_product_name != null) {                     //값이 존재하면 생성 || 에러 발생
//                dynamic_Home_view n_dynamicHomeview = new dynamic_Home_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기
//
//                n_dynamicHomeview.change_value(i);
//
//                LinearLayout con = (LinearLayout) findViewById(R.id.HScrollView_Linear); //추가할 레이아웃 위치
//                con.addView(n_dynamicHomeview);    //add View로 추가 명령
//            }
//            else                //배열에 값이 존재하지 않으면 종료
//            {
//                break;
//            }
        }
        //activityh_register_search 로 이동하는 버튼부분
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Register_Search_1.class);
                startActivity(intent);

            }
        });

        imgv_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Mypage_test2.class); //에러발생
                Toast.makeText(Home.this, "이미지 뷰 클릭", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                Product_save_list psl = new Product_save_list();

                TempTextView.setText(psl.export_memo[0]);
            }
        });





    }
}
