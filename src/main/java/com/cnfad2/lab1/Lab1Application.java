package com.cnfad2.lab1;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Lab1Application {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		SpringApplication.run(Lab1Application.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Customer c = (Customer) ac.getBean("customer");
		Ticket t = (Ticket) c.getTick();
		while(true) {
		System.out.println("1. insert the details\n2. Display details \n3. exit");
		System.out.println("enter the choice"); 
		int a = sc.nextInt();
		switch(a) {
			case 1:
				System.out.println("enter the customer name");
				c.setName(sc.next());
				System.out.println("enter the customer address"); 
				c.setAddress(sc.next()); 
				System.out.println("enter the ticket number"); 
				t.setTicno(sc.nextInt()); 
				System.out.println("enter the ticket seat no"); 
				t.setSeatno(sc.nextInt()); 
				System.out.println("enter the ticket price"); 
				t.setPrice(sc.nextInt());
				System.out.println("enter the ticket Type -economic/gold/platinum");
				t.setTicktype(sc.next());
				c.setTick(t); System.out.println("thanks for input"); 
				break;
		
			case 2:
				System.out.println("Customer Details:");
				System.out.println("Name:"+c.getName()+" "+"Address:"+c.getAddress());
				System.out.println("Ticket Details");
				t=c.getTick();
				System.out.println("Ticket No: "+t.getTicno());
				System.out.println("Ticket Type: "+t.getTicktype());
				System.out.println("Ticket Seat No: "+t.getSeatno());
				System.out.println("Ticket Price: "+t.getPrice());
				break;
				
			case 3:
				System.exit(0);}
		}
	}
}
