package com.example.demo5;

import lombok.Data;
import lombok.NoArgsConstructor;

//转账安全
public class SafeBank {
    public static void main(String[] args) {
        Account account=new Account("账户",1000);


        Banks thread1=new Banks(account,100,"1号");
        Banks thread2=new Banks(account,1000,"2号");

        thread1.start();
        thread2.start();
    }
}



@Data
@NoArgsConstructor
class  Banks extends Thread{

    private Account account;

    //取的钱
    private double drawMoney;

    private String names;

    //现在手里的钱
    double nowMoney;

    public Banks(Account account,double drawMoney,String names){
        super(names);
        this.account=account;
        this.drawMoney=drawMoney;
    }




    //synchronized默认锁的是this   本例为Banks    所以需要使用同步代码块，维护共同操作的任意对象
    @Override
    public void run() {
        //锁的对象就是变化的量
        synchronized (account){
            if(account.balance-drawMoney>=0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.balance=account.balance-drawMoney;
                nowMoney+=drawMoney;
                System.out.println(account.name+"余额"+account.balance);
                //继承Thread  this.getName()等价于Thread.currentThread().getName()
                System.out.println(this.getName()+"手里的钱"+nowMoney);
            }else{
                System.out.println("钱不够");
                return;
            }
        }

    }



}
