package main;

import java.util.Scanner;
import Producer.MyKafkaProducer;

public class ThreadProducer extends Thread {
	MyKafkaProducer myKafkaProducer=new MyKafkaProducer("Topic-A");
	Scanner i=new Scanner(System.in);
	public void run() {
		   while(true) {
			  synchronized(MyKafkaProducer.class) {
				  System.out.print("\nInput Your Message:");
				   String s = i.nextLine();
				   myKafkaProducer.produce(s);
			  }
		   }
	}
}
