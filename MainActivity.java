package com.example.p03_16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView tv;
    EditText edt_name;
    String msg1 ="";
    String result ="빈값 ";
    sendMsg sendMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv);
        edt_name = findViewById(R.id.edt_name);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable a = edt_name.getText();
                msg1= a.toString();
                System.out.println(msg1);
                APi thread = new APi();
                thread.start();
                try{
                    thread.join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sendMsg = new sendMsg();
    }
    class APi extends Thread
    {
        public void run () {
            String clientId = "EgHeTGEYbk2ttK5UYHXV"; //애플리케이션 클라이언트 아이디값"
            String clientSecret = "WHW8zhnfSp"; //애플리케이션 클라이언트 시크릿값"
            System.out.println("쓰레드 작동");

            String text = null;
            try {
                text = URLEncoder.encode(msg1, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("검색어 인코딩 실패", e);
            }


            String apiURL = "https://openapi.naver.com/v1/search/image?query=" + text;    // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("X-Naver-Client-Id", clientId);
            requestHeaders.put("X-Naver-Client-Secret", clientSecret);
            String responseBody = get(apiURL, requestHeaders);


            System.out.println(responseBody);
            Message message = sendMsg.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("msg",responseBody);
            message.setData(bundle);
            System.out.println("쓰레드 종료");
            System.out.println(msg1);
            result = responseBody;
            tv.setText(responseBody);
        }


        private  String get(String apiUrl, Map<String, String> requestHeaders){
            HttpURLConnection con = connect(apiUrl);
            try {
                con.setRequestMethod("GET");
                for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                    con.setRequestProperty(header.getKey(), header.getValue());
                }


                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                    return readBody(con.getInputStream());
                } else { // 에러 발생
                    return readBody(con.getErrorStream());
                }
            } catch (IOException e) {
                throw new RuntimeException("API 요청과 응답 실패", e);
            } finally {
                con.disconnect();
            }
        }


        private  HttpURLConnection connect(String apiUrl){
            try {
                URL url = new URL(apiUrl);
                return (HttpURLConnection)url.openConnection();
            } catch (MalformedURLException e) {
                throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
            } catch (IOException e) {
                throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
            }
        }


        private  String readBody(InputStream body){
            InputStreamReader streamReader = new InputStreamReader(body);


            try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                StringBuilder responseBody = new StringBuilder();


                String line;
                while ((line = lineReader.readLine()) != null) {
                    responseBody.append(line);
                }


                return responseBody.toString();
            } catch (IOException e) {
                throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
            }
        }
    }
    class sendMsg extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String Msg = bundle.getString("msg");
            tv.setText("msg"+msg);
        }
    }
}