package weekZ_10_threa;
import java.util.concurrent.Semaphore;
/*// A Semaphore is a thread synchronization construct 
that can be used either to send signals between threads to
avoid missed signals, 
or to guard a critical section like you would with a lock. 
*/
public class lesson9e_semaphores {
	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(1); // used to e.g. accss to resource 
		sem.acquire();
		sem.release();
		System.out.println("Available permits " + sem.availablePermits() );
		
		
		// because the aquire waits for an available permit
		// a sem with 1 permit andaquire works like a lock and unlock
		// the above works like a lock
		// with lock you have to unlock with the same thread
		// semaphores could be aquired and released with any thread
		
		// used to control some resource
		
	} //main
}//class
