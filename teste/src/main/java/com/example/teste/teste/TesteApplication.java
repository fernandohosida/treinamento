package com.example.teste.teste;

import java.util.concurrent.ThreadFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
		
		Runnable printThread = () -> System.out.println("Thread is -> "+Thread.currentThread());
		

		System.out.println("hello word");
		MyRunnableTask runn = new MyRunnableTask();

		Thread.startVirtualThread(printThread);
		Thread.startVirtualThread(printThread);
		Thread.startVirtualThread(printThread);
		Thread.startVirtualThread(printThread);
		Thread.startVirtualThread(printThread);
		Thread.startVirtualThread(runn);
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread Single is -> "+Thread.currentThread());
			}
		});
		t.start();

	}


	

}
