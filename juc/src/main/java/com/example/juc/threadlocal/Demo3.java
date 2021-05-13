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
public class Demo3 {

   static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(()->{
                Date date=new Date(finalI *1000);
                convertDate2(date);
            });
        }
        executorService.shutdown();
    }



    //多个线程操作同一个对象线程不安全 format中还调用了 calendar.setTime(date);   A线程set后可能暂停被B线程执行set修改了，A线程恢复执行后的值是被b修改过的
    public static void convertDate(Date date){

        String dates=simpleDateFormat.format(date);


        System.out.println(dates);
    }


    //线程安全,但是可能影响处理速度
    public static void convertDate2(Date date){
        synchronized (Demo3.class){
            String dates=simpleDateFormat.format(date);

            System.out.println(dates);
        }


    }






}
