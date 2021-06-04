package weekZ_10_threa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//class Processor implements Runnable {
public class lesson7_threadpool_app2  implements Runnable {
	/**
	 * ThreadPool ("number of workers in a factory")
	  	 */
	    private int id;
	    public lesson7_threadpool_app2(int id) {
	        this.id = id;
	    }
	    public void run() {
	        System.out.println("Starting: " + id);
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException ignored) {
	        }
	        System.out.println("Completed: " + id);
	    }
	}

	 