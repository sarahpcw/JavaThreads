package weekZ_10_threa;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*// A Semaphore is a thread synchronization construct 
that can be used either to send signals between threads to
avoid missed signals, 
or to guard a critical section like you would with a lock. 
*/
public class lesson9e_semaphores3 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		for ( int i=0; i<200 ;i++){ //this runs 200 threads
        	 executor.submit(new Runnable(){ 
				public void run() { 
					lesson9e_connections.getInstance().connect();
				}
        		 
        	 });
		
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	} //main
}//class
