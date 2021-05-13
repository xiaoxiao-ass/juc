package com.example.juc.forkjoin;

import java.util.concurrent.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       //普通计算

test1();
test2();
test3();





    }

    public static void test1(){
        Long start=System.currentTimeMillis();
        Long sum=0L;
        for (Long i = 1L; i <= 10000000L; i++) {
            sum+=i;
        }

        Long end=System.currentTimeMillis();

        System.out.println(sum+","+(end-start));

    }

    public static void test2() throws ExecutionException, InterruptedException {
        Long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinDemo forkJoinDemo=new ForkJoinDemo(0L, 10000000L);

        ForkJoinTask<Long> forkJoinTask=forkJoinPool.submit(forkJoinDemo);
        Long value=forkJoinTask.get();
        forkJoinPool.shutdown();

        Long end=System.currentTimeMillis();
        System.out.println(value+","+(end-start));

    }

    public static void test3()  {
        Long start=System.currentTimeMillis();

        Long result=LongStream.rangeClosed(0L, 10000000L).parallel().reduce(0,Long::sum);
        Long end=System.currentTimeMillis();
        System.out.println(result+","+(end-start));

    }
}





