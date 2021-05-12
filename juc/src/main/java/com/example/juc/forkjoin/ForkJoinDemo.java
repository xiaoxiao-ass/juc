package com.example.juc.forkjoin;

import lombok.Data;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@Data
public class ForkJoinDemo extends RecursiveTask<Long> {


    private Long start;

    private Long end;

    public ForkJoinDemo(Long start,Long end){
        this.start=start;
        this.end=end;
    }


    //临界值
    private Long temp = 10000L;


    @Override
    protected Long compute() {

        if(end-start<temp){
            Long sum=0L;
            for (Long i = start; i <=end; i++) {
                sum+=i;
            }
            return sum;
        }else {
            Long middle=(start+end)/2;
            //递归
            ForkJoinDemo forkJoinDemo1=new ForkJoinDemo(start,middle);
            //拆分任务，将任务压入线程队列
            forkJoinDemo1.fork();
            ForkJoinDemo forkJoinDemo2=new ForkJoinDemo(middle+1,end);
            //拆分任务，将任务压入线程队列
            forkJoinDemo2.fork();

            return forkJoinDemo1.join()+forkJoinDemo2.join();
        }
    }
}
