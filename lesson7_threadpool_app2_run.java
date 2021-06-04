package weekZ_10_threa;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class lesson7_threadpool_app2_run {
	    public static void main(String[] args) {
	        /**
	         * Created 2 threads, and assign tasks (Processor(i).run) to the threads
	         */
	        ExecutorService executor = Executors.newFixedThreadPool(5);//2 Threads
	        for (int i = 0; i < 5; i++) { // call the (Processor(i).run) 2 times with 2 threads
	            executor.submit(new lesson7_threadpool_app2(i));
	        }
	        executor.shutdown(); // stop accpeting new tasks, complete all running
	        System.out.println("All tasks submitted.");
	        try {
	            executor.awaitTermination(1, TimeUnit.DAYS);//wait until all is done, which will be earlier than a day
	        } catch (InterruptedException ignored) {
	        }
	        System.out.println("All tasks completed.");
	    }
	}

