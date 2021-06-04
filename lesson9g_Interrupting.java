package weekZ_10_threa;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class lesson9g_Interrupting {

	public static void main(String[] args) throws InterruptedException {
        	System.out.println("Starting ");
	  
	        Thread t1 = new Thread(new Runnable(){
	        	public void run(){
	        		Random random= new Random ();
	        		for ( int i=0; i<100000000 ;i++ ){ 
	        			if (Thread.currentThread().isInterrupted()){
	        				System.out.println("Interrupted");
	        				break;
	        			} 
		        		Math.sin(random.nextDouble());
	        		}
	        	}
	        });
	        t1.start();
	        Thread.sleep(200);
	        t1.interrupt();
	     // interrupt sets a flag, you have to check the flag 
	        //and then break or something to stop the thread
	        t1.join();
	        System.out.println("Finish ....");
	    }
	}