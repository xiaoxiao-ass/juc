package com.example.demo3;

public class LambdaDemo {

    //静态内部类
   static class B implements Test{
        @Override
        public void show() {
            System.out.println("静态内部类B-----------");
        }
    }


    public static void main(String[] args) {
        Test test=new A();
        test.show();


        test=new B();
        test.show();



        //局部内部类
        class C implements Test{

            @Override
            public void show() {
                System.out.println("局部内部类----------------");
            }
        }

        test=new C();
        test.show();

        //匿名内部类
        test=new Test() {
            @Override
            public void show() {
                System.out.println("匿名内部类版");
            }
        };
        test.show();

        //lambda表达式
        test=()-> System.out.println("lambda表达式版");
        test.show();



    }


}


class A implements Test{

    @Override
    public void show() {
        System.out.println("普通A--------------");
    }
}


interface Test{
    void show();
}
