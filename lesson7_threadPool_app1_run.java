package weekZ_10_threa;
import java.util.Random;
// cntl+shift+o
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class lesson7_threadPool_app1_run {

	    public static void main(String[] args) {
	    	Random r = new Random();
	        ExecutorService executor = Executors.newFixedThreadPool(2);
	        //two threads, try setting by 1 to observe time
	        //submit(Runnable task)
	        //Submits a Runnable task for execution and returns a 
	        //Future representing that task.
	        System.out.println("Starting ...");
	        long start = System.currentTimeMillis();
	        
	        lesson7_threadpool_app1 worker = new lesson7_threadpool_app1();
//	        for (int i = 0; i < 5; i++) {//worker.run is called 5 (threads started) times by two threads
//	            executor.submit(worker);
//	        }
	        executor.submit(worker); //thread 1
	        executor.submit(worker); //thread2
	        executor.submit(worker); // next available thread
	        executor.submit(worker); // next available
	        executor.submit(worker);
	        executor.submit(worker);
	        executor.shutdown(); 
	        //prevents new tasks from being accepted by the ExecutorService
	        
	        long end = System.currentTimeMillis();
	        System.out.println("End  : Time taken: " + (end - start));
	        System.out.println("List1: " + worker.list1.size() + "; List2: " + worker.list2.size());
	    
	    }  //main

	} // class

