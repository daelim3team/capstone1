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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class Register_Product extends AppCompatActivity {

    Button bt_submit;
    ImageButton imgbt_calender;
    EditText product_name,AS_date;
    TextView tv_date;
    DatePickerDialog datePickerDialog;
    String date;
    ImageView imageView;

    public void Declaration()
    {


        product_name = findViewById(R.id.product_name);
        AS_date = findViewById(R.id.AS_date);

        imgbt_calender = findViewById(R.id.bt_calender);
        tv_date=findViewById(R.id.tv_date);
        bt_submit = findViewById(R.id.button);

        imageView = findViewById(R.id.imageView);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        Declaration();

        String data = getIntent().getStringExtra("data");
        Picasso.get().load(data).into(imageView);

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
                                tv_date.setText(date);
                            }

                        },nYear,nMonth,nDay);
                datePickerDialog.show();
            }
        });

        Product_save_list save_list = new Product_save_list();

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p_name = product_name.getText().toString();
                String AS_dates = AS_date.getText().toString();
                String create_date = tv_date.getText().toString();
                String temp_url = "temp date";

                try {
                    //1.(쓰기) 메소드 호출과 동시에 에디트 택스트에서 받은것들 넘겨주기
                    writeToFile(p_name, AS_dates,create_date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Register_Product.this,Home.class);
                startActivity(intent);
            }
        });
    }


    public String readFromFile(String name) throws Exception {
        //2.(읽기) 받아온 이름경로 설정 하고
        FileInputStream fileInputStream = openFileInput(name);
        //3.(읽기) 버퍼에 연동해주기
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        //4.(읽기) 스트링 버퍼 생성
        StringBuffer stringBuffer = new StringBuffer();

        String content = null; // 4.(읽기) 리더에서 라인을 받아오는데 받아올게 없을때까지 반ㅁㄴ복
        while ((content = reader.readLine()) != null) {
            stringBuffer.append(content + "\n");
        }
        //사용한것들은 종료
        reader.close();
        fileInputStream.close();
        //5.(읽기)받아온 정보를 다시 리턴해준다
        return stringBuffer.toString();
    }


    public void writeToFile(String content1, String content2, String content3) throws Exception {
        //2.(쓰기) 자바랑은 다르게 openFileOutput(name, MODE_PRIVATE) 이렇게 사용하는데
        // 받아온 파일이름넣어주고 쉐어드프리퍼런드때 배웠던것처럼 나만 사용하게 하는 모드이다.
        FileOutputStream outputStream = openFileOutput("Product_data", MODE_APPEND);
        //3.(쓰기) OutputStreamWriter 여기에 위에서 파일 이름 설정을 해줌
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //실제 내용으로 작성하기
        writer.write(content1);
        writer.write("\n");
        writer.write(content2);
        writer.write("\n");
        writer.write(content3);
        writer.write("\n");
        writer.write("====================");
        writer.write("\n");
        //모든것들 종료 해줌
        writer.flush();
        writer.close();
        outputStream.close();
    }
}