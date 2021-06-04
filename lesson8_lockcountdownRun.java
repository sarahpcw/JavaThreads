package weekZ_10_threa;

/*
 * https://docs.oracle.com/javase/8/docs/api/index.html?java/util/concurrent/package-summary.html
 * 
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CountDownLatch.html#method_summary
 * A synchronization aid that allows one or more threads to wait until a 
 * set of operations being performed in other threads completes.
 */
	import java.util.concurrent.CountDownLatch;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	public class lesson8_lockcountdownRun {

	    public static void main(String[] args) {
	        CountDownLatch latch = new CountDownLatch(3);
	        ExecutorService executor = Executors.newFixedThreadPool(3);
	        for (int i = 0; i < 3; i++) {
	        	//lesson8_countdownlatch cd =new lesson8_countdownlatch(latch);
	        	executor.submit(new lesson8_countdownlatch(latch));
	        }
	        executor.shutdown();

	        try {
	            // Application’s main thread waits, till other service threads which are
	            // as an example responsible for starting framework services 
	        	//have completed started all services.
	            System.out.println("Await "+   latch.getCount()); 
	        	latch.await(); //waits until countdown is 0 per thread
	            
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Completed.");
	    }

	}

