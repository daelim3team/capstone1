package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.time.format.TextStyle;

public class Home extends AppCompatActivity {
    Button registration,Tempbutton_file;
    ImageView imgv_mypage;
    TextView TempTextView;
    String[] strarr = new String[90];

    public static Context context_main;

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
        context_main = this;

        Declaration();

        Product_save_list save_list = new Product_save_list();

        try {
            readFromFile1("Product_data");

            for (int i = 0; i <= readFromFile("Product_data"); i++) { //배열의 크기만큼 생성
                dynamic_Home_view n_dynamicHomeview = new dynamic_Home_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기

                n_dynamicHomeview.change_value(i,strarr);

                LinearLayout con = (LinearLayout) findViewById(R.id.HScrollView_Linear); //추가할 레이아웃 위치
                con.addView(n_dynamicHomeview);    //add View로 추가 명령

            }
        }
        catch (Exception e)
        {
            Toast.makeText(Home.this, "에러 발생", Toast.LENGTH_SHORT).show();
            System.out.println("다이나믹 뷰에서 에러 발생함");
            System.out.println("==============");
            System.out.println(e);
            System.out.println("==============");

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
//                Toast.makeText(Home.this, "이미지 뷰 클릭", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                Product_save_list psl = new Product_save_list();

                TempTextView.setText(psl.export_memo[0]);
            }
        });



    }

    public int readFromFile(String name) throws Exception {
        //2.(읽기) 받아온 이름경로 설정 하고
        FileInputStream fileInputStream = openFileInput(name);
        //3.(읽기) 버퍼에 연동해주기
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        //4.(읽기) 스트링 버퍼 생성
        StringBuffer stringBuffer = new StringBuffer();

        String content = null; // 4.(읽기) 리더에서 라인을 받아오는데 받아올게 없을때까지 반ㅁㄴ복
        int count = 0;
        int count2 = 0;
        while ((content = reader.readLine()) != null) {
            if(count == 6)
            {
                count = 0;
            }

            if(count == 0)
            {
                stringBuffer.append(content + "\n");
                count2 ++;
            }
            else
            {
                stringBuffer.append(content + "\n");
            }
            count ++;
        }
        //사용한것들은 종료
        reader.close();
        fileInputStream.close();
        //5.(읽기)받아온 정보를 다시 리턴해준다
        return count2 ;//stringBuffer.toString();
    }

    public String[] getStrarr() {
        return strarr;
    }

    public void setStrarr(String[] strarr) {
        this.strarr = strarr;
    }

    //파일을 읽기위한 메소드
    public String[] readFromFile1(String name) throws Exception {

//2.(읽기) 받아온 이름경로 설정 하고
        FileInputStream fileInputStream = openFileInput(name);
        //3.(읽기) 버퍼에 연동해주기
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        //4.(읽기) 스트링 버퍼 생성
        System.out.println("파일 실행됨");
        StringBuffer stringBuffer = new StringBuffer();
        String content = null; // 4.(읽기) 리더에서 라인을 받아오는데 받아올게 없을때까지 반ㅁㄴ복
        String Temp = "";
        int count = 0;
        int count2 = 0;
        String[] strarr2 = new String[90];

        while ((content = reader.readLine()) != null) {
            System.out.println("실행됨"+content);

            if(count<=3)
            {
                strarr2[count2] = content;
            }
            else if(count == 4)
            {
                count = -1;

            }
            count2++;
            count ++;
        }

        //사용한것들은 종료
        reader.close();
        fileInputStream.close();
        //5.(읽기)받아온 정보를 다시 리턴해준다
        setStrarr(strarr2);

        return strarr2;
    }
//    public void create(){
//        TextView textView = new TextView(getApplicationContext());
//        textView.setText();
//    }
}
