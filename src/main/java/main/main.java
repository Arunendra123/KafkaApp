package main;

public class main extends Thread{
     public static void main(String args[]) {
    	 ThreadConsumer tc=new ThreadConsumer();
    	 ThreadProducer tp=new ThreadProducer();
    	 tc.start();
    	 tp.start();
     }
}
