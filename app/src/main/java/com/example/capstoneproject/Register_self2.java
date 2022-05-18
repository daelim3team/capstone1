package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register_self2 extends AppCompatActivity {

        Button bt_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_self2);


        bt_registration = findViewById(R.id.button6);

        bt_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Product_save_list save_list = new Product_save_list();

                String[] A = save_list.export_product_name;

                Intent intent = new Intent(Register_self2.this,Home.class);

                startActivity(intent);
            }
        });
    }
}