package com.example.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        User user1=new User(1,"a",10);
        User user2=new User(2,"b",20);
        User user3=new User(3,"c",10);
        User user4=new User(4,"d",30);
        List<User> list=Arrays.asList(user1,user2,user3,user4);
        list.stream().filter(users-> users.getId()%2==0)
                     .filter(user -> user.getAge()>20)
                     .map(item->item.getName().toUpperCase())
                     .sorted((a1,a2)-> a2.compareTo(a1))
                     .limit(1)
                     .forEach(System.out::println);



    }
}


@Data
@AllArgsConstructor
class User{
    private int id;
    private String name;
    private int age;
}
