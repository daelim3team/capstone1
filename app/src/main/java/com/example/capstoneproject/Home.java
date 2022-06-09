package com.example.capstoneproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.time.format.TextStyle;

public class Home extends AppCompatActivity {
    Button registration,Tempbutton_file;
    ImageView imgv_mypage;
    TextView TempTextView;

    private static String CHANNEL_ID = "channel1";
    private static String CHANEL_NAME = "Channel1";

    public void Declaration()
    {
        setContentView(R.layout.activity_home);

        Tempbutton_file = findViewById(R.id.TempButton_file);

        registration = findViewById(R.id.button3);
        imgv_mypage = findViewById(R.id.imageView5);

        TempTextView = findViewById(R.id.textView8);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Declaration();

        Product_save_list save_list = new Product_save_list();

        for (int i = 0; i <= save_list.export_product_name.length; i++) { //배열의 크기만큼 생성
//            if(save_list.export_product_name != null) {                     //값이 존재하면 생성 || 에러 발생
//                dynamic_Home_view n_dynamicHomeview = new dynamic_Home_view(getApplicationContext());    //Test에 있는 자바와 XML 객체로 가져오기
//
//                n_dynamicHomeview.change_value(i);
//
//                LinearLayout con = (LinearLayout) findViewById(R.id.HScrollView_Linear); //추가할 레이아웃 위치
//                con.addView(n_dynamicHomeview);    //add View로 추가 명령
//            }
//            else                //배열에 값이 존재하지 않으면 종료
//            {
//                break;
//            }
        }
        //activityh_register_search 로 이동하는 버튼부분
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Register_Search_1.class);
                startActivity(intent);

            }
        });

        imgv_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Mypage_test2.class);
                startActivity(intent);
                Product_save_list psl = new Product_save_list();

                TempTextView.setText(psl.export_memo[0]);
            }
        });

//=====================================================파일 저장 테스트 코드

        Tempbutton_file = findViewById(R.id.TempButton_file);


        Tempbutton_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Context context = null;
                    FileOutputStream fos = context.openFileOutput("myFile.dat",MODE_APPEND);
//                    DataOutputStream dos = new DataOutputStream(fos);
                    //데이터를 쓴다.
//                    dos.writeInt(100);
//                    dos.writeUTF("문자열");
//                    dos.flush();
//                    dos.close();
                    Toast.makeText(Home.this, "파일 테스트 버튼 클릭됨", Toast.LENGTH_SHORT).show();

                }catch (Exception e){}

            }
        });

        //=====================================================파일 저장 테스트 코드 끝

        //=====================================================알람 코드 시작

//        create = findViewById(R.id.create);
//        remove = findViewById(R.id.remove);
        int value = 0;



        createNotification();
        //removeNotification();

    }

    private void createNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("제품 AS 기간 알림");
        builder.setContentText("-String- 제품의 AS 기간이 -int-만큼 남았습니다.");

        builder.setColor(Color.rgb(255,160,122));
        // 사용자가 탭을 클릭하면 자동 제거
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        // id값은
        // 정의해야하는 각 알림의 고유한 int값
        notificationManager.notify(1, builder.build());
    }

    private void removeNotification() {

        // Notification 제거
        NotificationManagerCompat.from(this).cancel(1);
    }

        //=====================================================알람 코드 끝

}
