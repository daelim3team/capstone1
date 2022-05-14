package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Register_Search_2 extends AppCompatActivity {
    LinearLayout Move_test_layout;
    TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search2);
        textView5 = findViewById(R.id.textView5);
        Move_test_layout = findViewById(R.id.Move_test_layout);
        Intent intent1 = getIntent();
        String rs1 = intent1.getStringExtra("url");
        textView5.setText(rs1);
    }
}