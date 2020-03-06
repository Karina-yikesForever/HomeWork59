package com.company;

public class Main {

    public static void main(String[] args) {
        int count=10;
        Counter counter= new Counter();

        Thread one=new Thread(new MyThread(counter,count,"+",5),"One");
        Thread two=new Thread(new MyThread(counter,count,"-",1),"Two");
        Thread three=new Thread(new MyThread(counter,count,"*",10),"Three");
        Thread four=new Thread(new MyThread(counter,count,"/",30),"Four");

        one.start();
        two.start();
        three.start();
        four.start();
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }
    }

