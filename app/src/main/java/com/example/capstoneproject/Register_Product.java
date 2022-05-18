package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register_Product extends AppCompatActivity {

    Button bt_submit;
    ImageButton imgbt_calender;
    TextView tv_date;
    DatePickerDialog datePickerDialog;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        imgbt_calender = findViewById(R.id.bt_calender);
        tv_date=findViewById(R.id.tv_date);
        bt_submit = findViewById(R.id.button);

        imgbt_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(Calendar.YEAR);
                int nMonth = calendar.get(Calendar.MONTH);
                int nDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(Register_Product.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker,int year,int month,int day){
                                month+=1;
                                date=year+"/"+month+"/"+day;
                                tv_date.setText("  출시일 :  "+date);
                            }

                        },nYear,nMonth,nDay);
                datePickerDialog.show();
            }
        });


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(Register_Product.this,Home.class);
            }
        });
    }
}