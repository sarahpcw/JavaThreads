package weekZ_10_threa;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class lesson7_threadPool_app3_run {
	
	public static void main(String[] args) {  
	        //creating a pool of 5 threads
	        ExecutorService executor = Executors.newFixedThreadPool(5); 
	        //creates 5 threads and submit to the executor queue
	        //ThreadPoolExecutor separates the task creation and 
	        //its execution  

	        for (int i = 0; i < 10; i++) {  
	        	
	        	lesson7_threadPool_app3 worker = new lesson7_threadPool_app3("" + i);  
	            executor.execute(worker);
	            //calling execute method of ExecutorService  
	          }  
	        executor.shutdown();  
	        //while (!executor.isTerminated()) {   }  
	        System.out.println("Finished all threads");  
	}  

	public void run() {
	        throw new UnsupportedOperationException("Not supported yet."); 
	        //To change body of generated methods
	    }
	} 
