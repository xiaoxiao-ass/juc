package com.example.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo2 {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new  Thread(()->{
                Date date=new Date(finalI *1000);
                convertDate(date);
            }).start();
        }



    }



    public static  void convertDate(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
        String dates=simpleDateFormat.format(date);

        System.out.println(dates);
    }






}
