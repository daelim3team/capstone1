package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.concurrent.ExecutionException;
import androidx.appcompat.widget.SearchView;


public class Register_Search_1 extends AppCompatActivity {

    Button import_bt, search_bt;
    static String msg1 = "";
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_1);
        import_bt = findViewById(R.id.bt1);
        search_bt = findViewById(R.id.bt1_search);
        searchView = findViewById(R.id.search_view);

        import_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Register_Search_1.this, register_self.class);
//
//                startActivity(intent);
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg1 = searchView.getQuery().toString(); // 검색단어 저장
                String res= ""; // api 값
                Intent intent = new Intent(Register_Search_1.this, Register_Search_2.class);
                AsyncTask<String, Void, String> test = new test(msg1);
                try {
                    res = test.execute().get(); // api 값 저장
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intent.putExtra("data",res); // Register_Search_2 로 이동
                startActivity(intent);
                System.out.println(res);
            }
        });

    }


}

class test extends AsyncTask<String, Void, String> // 비동기화 클래스
{
    String keyword = "";
    String result = "";
    public test(String keyword) {  //유저 입력값 받아오기
        this.keyword = keyword;
    }

    @Override
    protected void onPreExecute() { //AsyncTask 사전준비
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) { // Thread 생성 후 돌림
        String clientId = "EgHeTGEYbk2ttK5UYHXV"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "WHW8zhnfSp"; //애플리케이션 클라이언트 시크릿값"


        String apiURL = "https://openapi.naver.com/v1/search/image?query=" + keyword;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = Api.get(apiURL, requestHeaders);
        result = responseBody;

        return result;
    }

    @Override
    protected void onPostExecute(String result) { //doInBackground 값 리턴
        super.onPostExecute(result);
    }
}

 class Api { // naver open api
    static String get(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
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


    static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    static String readBody(InputStream body) {
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

