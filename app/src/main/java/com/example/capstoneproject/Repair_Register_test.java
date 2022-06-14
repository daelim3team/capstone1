package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class Repair_Register_test extends AppCompatActivity {

    //수리 데이터는 제품 데이터와 구분되어 있음 Product_save_list에서 확인
    ImageView imageView;
    Button bt_registration,TestIO;
    EditText et_fix_locate,et_fix_bill,et_memo,et_fixPart;
    TextView tv_date;
    DatePickerDialog datePickerDialog;
    String date;
    public void Declaration()
    {





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_register_test);

        tv_date = findViewById(R.id.textView6);

        imageView = findViewById(R.id.imageView4);

        et_fix_locate = findViewById(R.id.editTextTextPersonName);
        et_fix_bill = findViewById(R.id.editTextTextPersonName4);
        et_memo = findViewById(R.id.editTextTextPersonName6);
        et_fixPart = findViewById(R.id.editTextTextPersonName3);

        Declaration();
//============================================================== 에러 발생
        bt_registration = findViewById(R.id.bt_RegisterToHome);
//        TestIO = findViewById(R.id.button7);
//============================================================== 에러 발생

//        for(int i = 0; i<=10;i++){}

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(Calendar.YEAR);
                int nMonth = calendar.get(Calendar.MONTH);
                int nDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(Repair_Register_test.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                                month+=1;
                                date=year+"/"+month+"/"+day;
                                tv_date.setText(date);
                            }

                        },nYear,nMonth,nDay);
                datePickerDialog.show();
                }
        });




//        //버튼이 클릭되면 저장된 값을 내보냄
        bt_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //에디트 텍스트에 파일 이름 받아오기
                String content1 = et_fix_bill.getText().toString();
//                Toast.makeText(Repair_Register_test.this, "이미지 뷰 클릭", Toast.LENGTH_SHORT).show();

                //에디트 텍스트에서 내용 받아오기
                String content2 = et_fixPart.getText().toString();
                String conetent3 = et_fix_locate.getText().toString();
                String content4 = et_fix_bill.getText().toString();
                String content5 = tv_date.getText().toString();
                try {
                    //1.(쓰기) 메소드 호출과 동시에 에디트 택스트에서 받은것들 넘겨주기
                    writeToFile(content1, content2,conetent3,content4,content5);
                } catch (Exception e) {
                    e.printStackTrace();
                }


//                String str_fix_locate = et_fix_locate.getText().toString();
//                String str_fix_bill = et_fix_bill.getText().toString();
//                String str_memo = et_memo.getText().toString();
//                String strdate = tv_date.getText().toString();
//
//                Product_save_list save_list = new Product_save_list();
//
//                save_list.importvalue_repair(str_memo,strdate,str_fix_bill,str_fix_locate);
//                save_list.repair_file_export();

                Intent intent = new Intent(Repair_Register_test.this,Mypage_test2.class);
                startActivity(intent);
            }
        });

//        TestIO.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //1.(읽기) 에디트 텍스트에서 불러올 파일 받아오기
//                String name = "abcd";
//                String content = null;
//                try {
//                    //불러올 파일 이름을 던져주며 메소드 실행
//                    content = readFromFile(name);
//                    et_memo.setText(content);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    //파일을 읽기위한 메소드
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


    public void writeToFile(String content1, String content2, String content3,String content4,String content5) throws Exception {
        //2.(쓰기) 자바랑은 다르게 openFileOutput(name, MODE_PRIVATE) 이렇게 사용하는데
        // 받아온 파일이름넣어주고 쉐어드프리퍼런드때 배웠던것처럼 나만 사용하게 하는 모드이다.
        FileOutputStream outputStream = openFileOutput("abcd", MODE_APPEND);
        //3.(쓰기) OutputStreamWriter 여기에 위에서 파일 이름 설정을 해줌
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //실제 내용으로 작성하기
        writer.write(content1);
        writer.write("\n");
        writer.write(content2);
        writer.write("\n");
        writer.write(content3);
        writer.write("\n");
        writer.write(content4);
        writer.write("\n");
        writer.write(content5);
        writer.write("\n");
        writer.write("====================");
        writer.write("\n");
        //모든것들 종료 해줌
        writer.flush();
        writer.close();
        outputStream.close();
    }
}