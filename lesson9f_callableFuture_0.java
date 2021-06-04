package weekZ_10_threa;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class lesson9f_callableFuture_0 {

	public static void main(String[] args) {
        
	        ExecutorService executor = Executors.newFixedThreadPool(5);
	        //2 Threads
	        executor.submit(new Runnable(){
	        	public void run(){
	        		Random random= new Random ();
	        		int duration = random.nextInt(400);
	        		System.out.println("Starting .... ");
	        		try {
						Thread.sleep(duration);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					}
	        		System.out.println("Finish ....");
	        	}
	        });
	        executor.shutdown(); 
	     
	    }
	}