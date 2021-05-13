package com.example.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程转换时间
 */
public class Demo1 {


    public static void main(String[] args) {
        new  Thread(()->{
            Date date=new Date(1*1000);
            convertDate(date);
        }).start();

        new  Thread(()->{
            Date date=new Date(2*1000);
            convertDate(date);
        }).start();

    }



    public static  void convertDate(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
        String dates=simpleDateFormat.format(date);

        System.out.println(dates);
    }






}
