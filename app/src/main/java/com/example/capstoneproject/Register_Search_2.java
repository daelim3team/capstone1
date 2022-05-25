package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Register_Search_2 extends AppCompatActivity {
    LinearLayout Move_test_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_2);

        Move_test_layout = findViewById(R.id.Move_test_layout);

        Move_test_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Search_2.this,Register_Product.class);
                startActivity(intent);
            }
        });
    }
}