package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Repair_Register_test extends AppCompatActivity {

    //수리 데이터는 제품 데이터와 구분되어 있음 Product_save_list에서 확인
    Button bt_registration;
    EditText et_fix_locate,et_fix_bill,et_memo,et_fixPart;
    TextView tv_date;
    ImageView iv_calender;
    DatePickerDialog datePickerDialog;
    String date;

    public void Declaration()
    {


        tv_date = findViewById(R.id.textView6);

        et_fix_locate = findViewById(R.id.editTextTextPersonName);
        et_fix_bill = findViewById(R.id.editTextTextPersonName4);
        et_memo = findViewById(R.id.editTextTextPersonName6);
        et_fixPart = findViewById(R.id.editTextTextPersonName3);

        iv_calender=findViewById(R.id.imageView4);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_register_test);

        Declaration();
//============================================================== 에러 발생
        bt_registration = findViewById(R.id.bt_RegisterToHome);
//============================================================== 에러 발생

//        for(int i = 0; i<=10;i++){}


//                //버튼이 클릭되면 저장된 값을 내보냄
        bt_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_fix_locate = et_fix_locate.getText().toString();
                String str_fix_bill = et_fix_bill.getText().toString();
                String str_memo = et_memo.getText().toString();
                String strdate = tv_date.getText().toString();

                Product_save_list save_list = new Product_save_list();

                save_list.importvalue_repair(str_memo,strdate,str_fix_bill,str_fix_locate);
                save_list.repair_file_export();

                Intent intent = new Intent(Repair_Register_test.this,Mypage_test2.class);
                startActivity(intent);
            }
        });
        iv_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(Calendar.YEAR);
                int nMonth = calendar.get(Calendar.MONTH);
                int nDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(Repair_Register_test.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                                month+=1;
                                date=year+"/"+month+"/"+day;
                                tv_date.setText(date);
                            }

                        },nYear,nMonth,nDay);
                datePickerDialog.show();
            }
        });
    }
}