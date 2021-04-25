package com.example.demo5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//不安全转账，可能会超过账户余额
public class UnsafeThreadDemo2 {
    public static void main(String[] args) {
        Account account=new Account("账户",1000);


        Bank thread1=new Bank(account,100,"1号");
        Bank thread2=new Bank(account,1000,"2号");

        thread1.start();
        thread2.start();
    }
}


@AllArgsConstructor
@NoArgsConstructor
class Account{
     public String name;
     double balance;
}

@Data
@NoArgsConstructor
class  Bank extends Thread{

    private Account account;

    //取的钱
    private double drawMoney;

    private String names;

    //现在手里的钱
    double nowMoney;

    public Bank(Account account,double drawMoney,String names){
        super(names);
        this.account=account;
        this.drawMoney=drawMoney;
    }




    @Override
    public void run() {
        if(account.balance-drawMoney>=0){
            try {
                Thread.sleep(1000);
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
