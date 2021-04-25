package com.example.demo6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//死锁  互相持有对方需要的对象
public class DeadLock {
    public static void main(String[] args) {
        MakeUp makeUp=new MakeUp("xixiix",0);
        MakeUp makeUp2=new MakeUp("ssss",1);
        makeUp2.start();
        makeUp.start();
    }
}

//口红
class LipsTick{

}


//镜子
class  Mirror{

}


@Data
class MakeUp extends  Thread{
    LipsTick lipsTick=new LipsTick();
    Mirror mirror=new Mirror();

    private String names;
    private Integer choice;

    public MakeUp(String names,Integer choice){
        this.names=names;
        this.choice=choice;
    }


    @Override
    public void run() {
        makeUp();
    }

    private void makeUp(){
        if(choice==0){
            synchronized (lipsTick){
                System.out.println(this.names+"得到口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //在以获得的锁对象中在持有一个其他的对象会发生死锁
               /* synchronized (mirror){
                    System.out.println(this.names+"得到镜子");
                }*/
            }

            synchronized (mirror){
                System.out.println(this.names+"得到镜子");

            }
        }else {
            synchronized (mirror){
                System.out.println(this.names+"得到镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //同上理
               /* synchronized (lipsTick){
                    System.out.println(this.names+"得到口红");
                }*/
            }
            synchronized (lipsTick){
                System.out.println(this.names+"得到口红");
            }
        }

    }

}



