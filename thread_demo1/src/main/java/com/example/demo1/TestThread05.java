package com.example.demo1;

//模拟龟兔赛跑
public class TestThread05 implements Runnable{

    private String winner;


    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if(Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           boolean flag=race(i);
           if(flag==true){
               break;
           }
            System.out.println(Thread.currentThread().getName()+"走了"+i+"步");
        }

    }


    public boolean race(int step){
        if(winner!=null){
            System.out.println(winner+"赢了");
            return true;
        }else{
            if(step==100){
                winner=Thread.currentThread().getName();
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        TestThread05 runnable=new TestThread05();
        Thread thread1=new Thread(runnable,"兔子");
        Thread thread2=new Thread(runnable,"乌龟");
        thread1.start();
        thread2.start();

    }

}
