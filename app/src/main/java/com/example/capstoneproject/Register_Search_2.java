package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Register_Search_2 extends AppCompatActivity {
    LinearLayout Move_test_layout;
    ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_2);
        iv1 = findViewById(R.id.imageView2);
        iv2 = findViewById(R.id.imageView7);
        String[] getLink = new String[10];
        Move_test_layout = findViewById(R.id.Move_test_layout);
        String data = getIntent().getStringExtra("data");
        try{
            JSONObject jsonObject = new JSONObject(data);
            String linkget = jsonObject.getString("items");
            JSONArray linkA = new JSONArray(linkget);
            for(int i=0; i<10; i++)
            {
                JSONObject jsonObject1 = linkA.getJSONObject(i);
                getLink[i] = jsonObject1.getString("link");
                System.out.println(getLink[i]);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Picasso.get().load(getLink[0]).into(iv1);
        Picasso.get().load(getLink[1]).into(iv2);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Search_2.this,Register_Product.class);
                intent.putExtra("data",getLink[0]);
                startActivity(intent);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Search_2.this,Register_Product.class);
                intent.putExtra("data",getLink[1]);
                startActivity(intent);
            }
        });

    }
}