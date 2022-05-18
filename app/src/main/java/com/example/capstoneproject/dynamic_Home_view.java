package com.example.capstoneproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.TextView;

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

    public void change_value(int value)
    {

        Product_name = findViewById(R.id.textView18);
        using = findViewById(R.id.textView22);
        as_term = findViewById(R.id.textView26);

        Product_save_list save_list = new Product_save_list();

        String[] A = save_list.import_product_name;
        String[] B = save_list.import_product_date;
        String[] C = save_list.import_product_afterservice;

        Product_name.setText(A[value]);
        using.setText(B[value]);
        as_term.setText(C[value]);

    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_dynamic_mainxml,this,true);
    }

}