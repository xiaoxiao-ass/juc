package com.example.demo7;

import lombok.AllArgsConstructor;
import lombok.Data;

//管程法    生产者《= =》缓冲区《==》消费者
public class ProductCustomerDemo {

    public static void main(String[] args) {
        SyncContainer container=new SyncContainer();
        new Product(container).start();
        new Customer(container).start();
    }
}


//生产者
@Data
@AllArgsConstructor
class  Product extends Thread{
    private SyncContainer container;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }



}

//消费者
@Data
@AllArgsConstructor
class Customer extends   Thread{
    private SyncContainer container;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop()+"只鸡");

        }
    }
}


@Data
@AllArgsConstructor
class Chicken{
    private int id;
}

//缓冲区
class  SyncContainer{

    //容器大小
    Chicken[] product=new Chicken[10];

    //容器计数器
    int count=0;


    //生产者放入数据
    public synchronized  void push(Chicken chicken){
        //如果容器满了就需要等待消费者消费
        if(product.length==count){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            //如果没有满，存入产品
            product[count]=chicken;
            count++;
            this.notifyAll();
        }
    }




    //消费者消费数据
    public synchronized  Chicken pop(){
        //如果容器没有数据，消费者进入等待
        if(count==0) {
            //消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
            Chicken chicken = product[count];

            this.notifyAll();
            return chicken;


    }

}