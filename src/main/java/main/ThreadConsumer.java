package main;

import Consumer.MyKafkaConsumer;

public class ThreadConsumer extends Thread{
   MyKafkaConsumer myKafkaConsumer=new MyKafkaConsumer("Topic-A");
   public void run() {
	 synchronized(ThreadConsumer.class) {
		 myKafkaConsumer.consume();
	 }
   }
}
