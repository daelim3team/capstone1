package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register_Product extends AppCompatActivity {

    Button bt_submit;
    ImageButton imgbt_calender;
<<<<<<< HEAD
    EditText product_name,AS_date;
    TextView tv_date;
    DatePickerDialog datePickerDialog;
    String date;

    public void Declaration()
    {


        product_name = findViewById(R.id.product_name);
        AS_date = findViewById(R.id.AS_date);

        imgbt_calender = findViewById(R.id.bt_calender);
        tv_date=findViewById(R.id.tv_date);
        bt_submit = findViewById(R.id.button);

    }

=======
    TextView tv_date;
    DatePickerDialog datePickerDialog;
    String date;
>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

<<<<<<< HEAD
        Declaration();
=======
        imgbt_calender = findViewById(R.id.bt_calender);
        tv_date=findViewById(R.id.tv_date);
        bt_submit = findViewById(R.id.button);
>>>>>>> master

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

        Product_save_list save_list = new Product_save_list();

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p_name = product_name.toString();
                String AS_dates = AS_date.toString();
                String create_date = tv_date.toString();
                String temp_url = "temp date";

                save_list.importvalue_product(p_name,create_date,temp_url,AS_dates);
                save_list.product_file_export();

                Intent intent = new Intent(Register_Product.this,Home.class);
            }
        });
    }
}