package com.example.capstoneproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.LinearLayout;

public class dynamic_Home_view extends LinearLayout {

    public dynamic_Home_view(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public dynamic_Home_view(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_dynamic_mainxml,this,true);
    }

}