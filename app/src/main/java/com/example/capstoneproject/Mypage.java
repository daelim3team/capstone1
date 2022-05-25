package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Mypage extends AppCompatActivity {

    Button bt_repair_registration;
    TextView tv_bill,tv_repairCount;
    public void Declaration()
    {
        bt_repair_registration = findViewById(R.id.button2);

        tv_bill = findViewById(R.id.textView37);
        tv_repairCount = findViewById(R.id.textView40);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Product_save_list save_list = new Product_save_list();

        Declaration();

        String[] bill = save_list.export_repair_bill;
        int count = bill.length;
        int result = 0;

        for(int i = 0; i < count ; i++)
        {
            result += Integer.parseInt(bill[i]);
        }

        tv_bill.setText(count);
        tv_repairCount.setText(result);


//        dynamic_mypage_view n_test = new dynamic_mypage_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기
//        LinearLayout con = (LinearLayout) findViewById(R.id.scrollview_Linear1); //추가할 레이아웃 위치
//        con.addView(n_test);    //add View로 추가 명령


        bt_repair_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mypage.this,Repair_Register.class);
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



}