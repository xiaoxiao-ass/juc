package com.example.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举不能通过反射破坏单例
 */
public enum  EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }


}


class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle enumSingle=EnumSingle.INSTANCE;
       Constructor<EnumSingle> constructor= EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingle enumSingle1=constructor.newInstance();
        System.out.println(enumSingle);
        System.out.println(enumSingle1);
    }
}
