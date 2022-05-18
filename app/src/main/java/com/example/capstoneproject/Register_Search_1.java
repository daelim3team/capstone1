package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Register_Search_1 extends AppCompatActivity {

    Button import_bt,search_bt;

    public void Declaration()
    {
        import_bt = findViewById(R.id.bt1);
        search_bt = findViewById(R.id.bt1_search);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_1);

        Declaration();

        import_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Register_Search_1.this, Register_self2.class);

                startActivity(intent);//넘어간 이후 에러 발생
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getApplicationContext(),"추후 업데이트 예정~", Toast.LENGTH_SHORT);
                myToast.show();
//                Intent intent = new Intent(Register_Search_1.this,Register_Search_2.class);
//                startActivity(intent); //개발 예정
            }
        });
    }
}