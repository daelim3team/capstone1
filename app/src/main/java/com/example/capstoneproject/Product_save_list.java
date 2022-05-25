package com.example.capstoneproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Product_save_list {
    String[] export_product_name = new String[500];
    String[] export_product_date = new String[500];
    String[] export_product_img_url = new String[500];
    String[] export_product_afterservice = new String[500];

    String[] export_memo = new String[500];
    String[] export_repair_date = new String[500];
    String[] export_repair_location = new String[500];
    String[] export_repair_bill = new String[500];

    String[] import_product_name = new String[500];
    String[] import_product_date = new String[500];
    String[] import_product_img_url = new String[500];
    String[] import_product_afterservice = new String[500];

    String[] import_memo = new String[500];
    String[] import_repair_date = new String[500];
    String[] import_repair_location = new String[500];
    String[] import_repair_bill = new String[500];

    public void importvalue_product(String A,String B,String C,String D)
    {
        for(int i = 0;i <500;i++)
        {
            if(export_product_name != null)
            {
                export_product_name[i] = A;
                export_product_date[i] =B;
                export_product_img_url[i] = C;
                export_product_afterservice[i] = D;
            }
        }
    }

    public void importvalue_repair(String A,String B,String C,String D)
    {
        for(int i = 0;i <500;i++)
        {
            if(export_product_name != null)
            {
                export_memo[i] = A;
                export_repair_date[i] =B;
                export_repair_location[i] = C;
                export_repair_bill[i] = D;
            }
        }
    }

    public void product_file_export()      //제품 데이터 저장 구현부분
    {
        try {
            File file = new File("\\product_data.txt");       //가변 파일 저장 경로
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){


                for(int i = 0;export_product_name[i] != null; i++)//배열에 저장된 4개의 데이터를 파일로 정리
                {
                    bufferedWriter.write(export_product_name[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_product_date[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_product_img_url[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_product_afterservice[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write("<--"+i+"-->");
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void repair_file_export()        //제품 수리 데이터 저장 부분
    {
        try {
            File file = new File("\\repair_data.txt");       //가변 파일 저장 경로
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){


                for(int i = 0;export_product_name[i] != null; i++)//배열에 저장된 4개의 데이터를 파일로 정리
                {
                    bufferedWriter.write(export_repair_date[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_repair_location[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_repair_bill[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write(export_memo[i]);
                    bufferedWriter.newLine();
                    bufferedWriter.write("<--"+i+"-->");
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void save_date_import()      //제품 데이터 가져오기 부분
    {
        try{
            //파일 객체 생성
            File file = new File("\\product_data.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){
                if(i == 0) {
                    import_product_name[i] = line;
                }
                else if(i == 1) {
                    import_product_date[i] = line;
                }
                else if(i == 2) {
                    import_product_img_url[i] = line;
                }
                else if(i == 3) {
                    import_product_afterservice[i] = line;
                }
                else if(line == "<--"+i+"-->")
                {

                }
                i++;
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void save_repair_date_import()       //제품 수리 데이터 가져오기 부분
    {
        try{
            //파일 객체 생성
            File file = new File("\\repair_data.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){
                if(i == 0) {
                    import_repair_date[i] = line;
                }
                else if(i == 1) {
                    import_repair_location[i] = line;
                }
                else if(i == 2) {
                    import_repair_bill[i] = line;
                }
                else if(i == 3) {
                    import_memo[i] = line;
                }
                else if(line == "<--"+i+"-->")
                {

                }
                i++;
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }



}
