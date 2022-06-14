package com.example.capstoneproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class dynamic_Home_view extends LinearLayout {
    TextView Product_name,using,as_term;



    public dynamic_Home_view(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public dynamic_Home_view(Context context) {
        super(context);

        init(context);
    }


    String[] A = new String[90];

    public void change_value(int value)
    {

        Product_name = findViewById(R.id.textView18);
        using = findViewById(R.id.textView22);
        as_term = findViewById(R.id.textView26);
        using.setText("Success");

        Home save_list = new Home();
        try {
            A = save_list.readFromFile1("Product_data");
        }
        catch (Exception e)
        {
            Product_name.setText("Error occur");

        }

        Product_name.setText(A[value]);
        using.setText(A[value+1]);
        as_term.setText(A[value+2]);
        Product_name.setText("성공");

    }

    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_dynamic_mainxml,this,true);
    }



}