package com.example.teste.teste;

public class MyRunnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread by Runnable is -> "+Thread.currentThread());
    }
    
}
