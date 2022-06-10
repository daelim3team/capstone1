package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Mypage_test2 extends AppCompatActivity {


    Button bt_repair_registration;
    TextView tv_bill,tv_repairCount;
    public void Declaration()
    {
        bt_repair_registration = findViewById(R.id.button2);

        tv_bill = findViewById(R.id.textView40);
        tv_repairCount = findViewById(R.id.textView37);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_test2);

        Product_save_list save_list = new Product_save_list();

        Declaration();

//        String[] bill = save_list.export_repair_bill;
//        int count = bill.length;
//        int result = 0;
//
//        for(int i = 0; i < count ; i++)
//        {
//            result += Integer.parseInt(bill[i]);
//        }
//
//        tv_bill.setText(count);
//        tv_repairCount.setText(result);


//        dynamic_mypage_view n_test = new dynamic_mypage_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기
//        LinearLayout con = (LinearLayout) findViewById(R.id.scrollview_Linear1); //추가할 레이아웃 위치
//        con.addView(n_test);    //add View로 추가 명령


        //1.(읽기) 에디트 텍스트에서 불러올 파일 받아오기
        String name = "abcd";
        String content = null;
        try {
            //불러올 파일 이름을 던져주며 메소드 실행
            content = readFromFile(name);
            tv_repairCount.setText(content);
            tv_bill.setText(readFromFile1(name));
        } catch (Exception e) {
            e.printStackTrace();
        }

        bt_repair_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mypage_test2.this,Repair_Register_test.class);
                startActivity(intent);
            }
        });



//        bt_repair_registration.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(Mypage.this,Repair_Register.class);
//                        startActivity(intent);
//                    }
//                }
//        );



    }





    //파일을 읽기위한 메소드
    public String readFromFile1(String name) throws Exception {
//2.(읽기) 받아온 이름경로 설정 하고
        FileInputStream fileInputStream = openFileInput(name);
        //3.(읽기) 버퍼에 연동해주기
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        //4.(읽기) 스트링 버퍼 생성
        StringBuffer stringBuffer = new StringBuffer();
        String content = null; // 4.(읽기) 리더에서 라인을 받아오는데 받아올게 없을때까지 반ㅁㄴ복
        String Temp = "";
        int count = 0;
        int count2 = 0;

        while ((content = reader.readLine()) != null) {

            if(count == 0)
            {
                String stringTest = content.toString();
                Toast.makeText(Mypage_test2.this, stringTest, Toast.LENGTH_SHORT).show();
                count2 += Integer.parseInt(stringTest.trim());
            }
            if(count == 5)
            {
                count = -1;
            }
            count ++;
        }

        //사용한것들은 종료
        reader.close();
        fileInputStream.close();
        //5.(읽기)받아온 정보를 다시 리턴해준다
        Temp = Integer.toString(count2);
        return Temp;
    }

    //파일을 읽기위한 메소드
    public String readFromFile(String name) throws Exception {
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
        return Integer.toString(count2) ;//stringBuffer.toString();
    }
}