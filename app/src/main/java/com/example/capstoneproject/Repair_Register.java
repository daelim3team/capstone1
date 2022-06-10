package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Repair_Register extends AppCompatActivity {

//수리 데이터는 제품 데이터와 구분되어 있음 Product_save_list에서 확인
    Button bt_registration;
    EditText et_fix_locate,et_fix_bill,et_memo;
    TextView tv_date;

//    public void Declaration()
//    {
//        //bt_registration = findViewById(R.id.bt_RegisterToHome);
//        bt_registration = findViewById(R.id.button4);
//
//        tv_date = findViewById(R.id.tv_date_register_product);
//
//        et_fix_locate = findViewById(R.id.editTextTextPersonName);
//        et_fix_bill = findViewById(R.id.editTextTextPersonName4);
//        et_memo = findViewById(R.id.editTextTextPersonName6);
//
//
//
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_repair_register_test);
//
//
//        Declaration();
//
//        String str_fix_locate = et_fix_locate.toString();
//        String str_fix_bill = et_fix_bill.toString();
//        String str_memo = et_memo.toString();
//        String strdate = tv_date.toString();
//
//         for(int i = 0; i<=10;i++){}
//        Toast.makeText(getApplicationContext(),"출력됨 : ", Toast.LENGTH_SHORT);
//         bt_registration.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 Toast.makeText(getApplicationContext(),"출력됨 : ", Toast.LENGTH_SHORT);
//                 //에디트 텍스트에 파일 이름 받아오기
//                 String content1 = et_fix_bill.getText().toString();
//                 Toast.makeText(getApplicationContext(),"출력됨 : "+content1, Toast.LENGTH_SHORT);
//
//                 //에디트 텍스트에서 내용 받아오기
//                 String content2 = et_fix_locate.getText().toString();
//                 try {
//                     //1.(쓰기) 메소드 호출과 동시에 에디트 택스트에서 받은것들 넘겨주기
//                     writeToFile(content1, content2);
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//
//                 //============================================================================
//                 //버튼이 클릭되면 저장된 값을 내보냄
////                 Product_save_list save_list = new Product_save_list();
////
////                 save_list.importvalue_repair(str_memo,strdate,str_fix_bill,str_fix_locate);
////                 save_list.repair_file_export();
////
////                 Intent intent = new Intent(Repair_Register.this,Mypage.class);
////                 startActivity(intent);
//             }
//         });
//    }
//    //파일을 쓰기위한 메소드
//    public void writeToFile(String content1, String content2) throws Exception {
//        //2.(쓰기) 자바랑은 다르게 openFileOutput(name, MODE_PRIVATE) 이렇게 사용하는데
//        // 받아온 파일이름넣어주고 쉐어드프리퍼런드때 배웠던것처럼 나만 사용하게 하는 모드이다.
//        FileOutputStream outputStream = openFileOutput("fix_data", MODE_PRIVATE);
//        //3.(쓰기) OutputStreamWriter 여기에 위에서 파일 이름 설정을 해줌
//        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
//        //실제 내용으로 작성하기
//        writer.write(content1);
//        writer.write(content2);
//        //모든것들 종료 해줌
//        writer.flush();
//        writer.close();
//        outputStream.close();
//    }
//

}