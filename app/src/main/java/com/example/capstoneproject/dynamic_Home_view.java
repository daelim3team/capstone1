package com.example.capstoneproject;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;



public class dynamic_Home_view extends LinearLayout {
    TextView Product_name,using,as_term;

   // ImageView imageView;

    public dynamic_Home_view(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public dynamic_Home_view(Context context) {
        super(context);

        init(context);
    }
    TextView p_name,p_data,p_repair,p_url;
    ImageView imageView;

    public void change_value(int value,String[] C)
    {
        System.out.println("다이나믹 실행됨");

        p_name = findViewById(R.id.textView18);
        p_data = findViewById(R.id.textView22);
        p_repair = findViewById(R.id.textView26);

        imageView = findViewById(R.id.image_view123);

        p_name.setText("제품명 : "+C[value*4+0]);
        p_data.setText(C[value*4+2]);
        p_repair.setText(C[value*4+1]);

        Uri uri =Uri.parse(C[value*4+3]); ;
        imageView.setImageURI(uri);


    }

    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_dynamic_mainxml,this,true);
    }

}