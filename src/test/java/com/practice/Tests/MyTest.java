package com.practice.Tests;

public class MyTest {
    MyTest(){
        System.out.println("I am from constructor");
    }

    {
        System.out.println("I am from blank curly braces");
    }
    static{
        System.out.println("I am form Static block");
    }

    public static void main(String[] args) {
        MyTest t= new MyTest();
        MyTest t1= new MyTest();
        String s= "new";
        s.concat("name");
        System.out.println(s);
    }
}
