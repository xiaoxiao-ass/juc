package com.example.demo7;

import lombok.AllArgsConstructor;

//信号灯法  通过标志位实现
public class LightDemo {

    public static void main(String[] args) {
        TV tv=new TV();
     new Player(tv).start();
     new Watcher(tv).start();
    }
}

//生产者 -》演员
@AllArgsConstructor
class Player extends Thread{
    public TV tv;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                tv.play("莫卡卡卡卡");
            }else{
                tv.play("hahhahaha");
            }

        }
    }
}


//消费者-》观众
@AllArgsConstructor
class Watcher extends Thread{
    private TV tv;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-》节目
class  TV {
    //演员表演，观众等待 T
    //观众等待，演员表演  F
    public String voice;
    public boolean flag=true;




    public synchronized  void play(String voices){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice=voices;
        System.out.println("演员表演"+voice);
        this.notifyAll(); //通知观众观看

        this.flag=!this.flag;
    }


    //观看
    public synchronized  void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看"+this.voice);
        this.notifyAll();
        this.flag=!this.flag;
    }





}
