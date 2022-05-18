package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Repair_Register extends AppCompatActivity {

//수리 데이터는 제품 데이터와 구분되어 있음 Product_save_list에서 확인
    Button bt_registration;
    EditText et_fix_locate,et_fix_bill,et_memo;
    TextView tv_date;

    public void Declaration()
    {
        bt_registration = findViewById(R.id.button4);

        tv_date = findViewById(R.id.tv_date_register_product);

        et_fix_locate = findViewById(R.id.editTextTextPersonName);
        et_fix_bill = findViewById(R.id.editTextTextPersonName4);
        et_memo = findViewById(R.id.editTextTextPersonName6);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_register);


        Declaration();

        String str_fix_locate = et_fix_locate.toString();
        String str_fix_bill = et_fix_bill.toString();
        String str_memo = et_memo.toString();
        String strdate = tv_date.toString();

         for(int i = 0; i<=10;i++){}

         bt_registration.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 //버튼이 클릭되면 저장된 값을 내보냄
                 Product_save_list save_list = new Product_save_list();

                 save_list.importvalue_repair(str_memo,strdate,str_fix_bill,str_fix_locate);
                 save_list.repair_file_export();

                 Intent intent = new Intent(Repair_Register.this,Mypage.class);
                 startActivity(intent);
             }
         });
    }


}