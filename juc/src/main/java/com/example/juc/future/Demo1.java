package com.example.juc.future;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        });

        System.out.println("--------------------");

        System.out.println(completableFuture.get());


        CompletableFuture<Integer> completedFuture2= CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            //throw new RuntimeException();

            return 1024;
        });
        System.out.println(Thread.currentThread().getName());
        System.out.println(completedFuture2.get());


        System.out.println(completedFuture2.whenComplete((r,e)->{
            System.out.println(r+","+e);
        }).get());


        CompletableFuture<User> completedFuture3= CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            throw new RuntimeException();

           // return new User(1);
        });


        System.out.println(completedFuture3.whenComplete((r,e)->{
            System.out.println("+++++++++++++=");

           r.setId(2);
        }).exceptionally(e-> new User(0)).get());





    }


}

@Data
@AllArgsConstructor
class User{
    private int id;
}
