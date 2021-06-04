package weekZ_10_threa;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class lesson9g_Interrupting1 {

	public static void main(String[] args) throws InterruptedException {
        	System.out.println("Starting ");
	  
	        Thread t1 = new Thread(new Runnable(){
	        	public void run(){
	        		Random random= new Random ();
	        		for ( int i=0; i<100 ;i++){ 
	        			
		        		try {
							Thread.sleep(1);
							
						} 
		        		catch (InterruptedException e) {  
							System.out.println("interrupted ");
							break;
						}
		        		Math.sin(random.nextDouble());
		        		System.out.println(i);
	        		}// for
	        	}
	        });
	        t1.start();
	        Thread.sleep(200);
	        t1.interrupt(); 
	        // interrupt sets a flag, send an interrupt to the thread
	        // you have to check the flag with try/catch
	        // and then break or something to stop the thread 
	        // in the catch clause
	        t1.join();
	        System.out.println("Finish ....");
	     
	    }
	}