package com.example.demo3;

public class LambdaDemo2 {

    public static void main(String[] args) {

        //无参
       Test test=()-> System.out.println("hhahhahhaha");
       test.show();

       //有参   多个参数逗号，隔开
        TestB b=null;
        b=(int a)-> System.out.println(a);
        b.display(11);


        b=(a)-> System.out.println(a);
        b.display(10);

        b=a-> System.out.println(a);
        b.display(12);
    }




}
interface TestB{
    void display(int a);
}



//函数式接口可以使用lambda表达式          只有一个抽象方法的接口是函数式接口
interface Tests{
    void show();

}
