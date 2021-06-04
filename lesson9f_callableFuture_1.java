package weekZ_10_threa;
/*
 * Runnable is the core interface provided for representing multi-threaded tasks 
 *  and Callable is an improved version of Runnable 
 * that was added in Java 1.5.
 * Both interfaces are designed to represent a task that 
 * can be executed by multiple threads.
 * DIFFERENCES
 *  Runnable tasks can be run using the Thread class or ExecutorService 
 * whereas Callables can be run only using the latter.
 * A Runnable object does not return a result
 *  whereas a Callable object returns a result. 
 *  A Runnable object cannot throw a checked exception 
 * wheras a Callable object can throw an exception. 
https://www.baeldung.com/java-runnable-callable
The Callable object returns a Future object which provides methods
 to monitor the progress of a task being executed by a thread. ... 
 The future object can be used to check the status of a Callable 
 and then retrieve the result 
from the Callable once the thread is done.
A Java Future, java. ... Future , represents the result 
of an asynchronous computation. When the asynchronous task is created, 
a Java Future object is returned. This Future object functions 
as a handle to the result of the asynchronous task.
*/

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class lesson9f_callableFuture_1 {

	public static void main(String[] args) {
        
	        ExecutorService executor = Executors.newFixedThreadPool(5);//2 Threads
	        // need the future to get values back from the call method
	        Future<Integer> future =executor.submit(new Callable<Integer>(){
	        	// it can be Interger or any data type that you want to return
	        	public Integer call() throws Exception{ 
	        		// Callable must implement call
	        		Random random= new Random ();
	        		int duration = random.nextInt(4000);
	        		if (duration > 2000){
	        			// I can make a new exception handler when in call , not run
	        			throw new IOException("Sleeping for too long");
	        		}
	        		System.out.println("Starting .... ");
	        		try {
						Thread.sleep(duration);
					} catch (InterruptedException e) { 
						e.printStackTrace();
					}
	        		System.out.println("Finish ....");
	        		return duration; // this is the return value provided by the call method
	        	}
	        });
	        executor.shutdown(); 
	        
	        try {
	        	System.out.println("Result " + future.get()); //info from future
	        	// if get throws an exception, it will be an execution exception and 
	        	// not my own created exception IOException 
	        	System.out.println("future.isDone() " + future.isDone());
	        } catch (InterruptedException e){
	        	System.out.println(" InterruptedException " + e);
	        } catch (ExecutionException e){
	        	System.out.println("Execution exp " + e);
	        	System.out.println(e.getMessage());
	        	IOException ex = (IOException) e.getCause();
	        	ex.getMessage();
	        }
	    }
	}