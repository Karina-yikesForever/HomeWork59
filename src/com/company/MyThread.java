package com.company;

public class MyThread implements Runnable{
    private final Counter counter;
    private int amount ;
    private final String operation;
    private final int delayMS;

    public MyThread(Counter counter, int count, String operation, int delayMS) {
        this.counter = counter;
        this.operation = operation;
        this.delayMS = delayMS;
    }


    @Override
    public void run() {
        int number;
        int result;
        try {
            while (!Thread.currentThread().isInterrupted()&& this.amount !=0){
                number= this.counter.getCount();
                result= solution(number,this.operation);
                this.counter.setCount(result);
                System.out.printf("Thread [%s]: %d %s 2 = %d;",Thread.currentThread().getName(),
                        number ,this.operation,result);
                this.amount--;
                Thread.sleep(this.delayMS);
            }
        }catch (InterruptedException e){
            //  System.out.println("Thread [" + Thread.currentThread().getName() + "] is stopped.");
        }
//        System.out.println(solution(50,"*"));
//        System.out.println(solution(10,"/"));
    }
    private int solution(int number,String operation){
        if (operation !=null) {
            if (operation.equals("+")) {
                number += 2;
            } else if (operation.equals("-")) {
                number -= 2;
            } else if (operation.equals("*")) {
                number *= 2;
            } if (operation.equals("/")){
                number /= 2;
            }
        }
        return number;
    }

}

