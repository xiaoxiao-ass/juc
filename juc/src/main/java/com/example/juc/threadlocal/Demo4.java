package com.example.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Demo4 {


    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal=ThreadLocal.withInitial(()->new SimpleDateFormat("mm:ss"));

    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            
            executorService.execute(()->{
                Date date=new Date(finalI *1000);
                convertDate(date);
            });
        }
        executorService.shutdown();
    }



    public static void convertDate(Date date){

        String dates=simpleDateFormatThreadLocal.get().format(date);


        System.out.println(dates);
    }









}
