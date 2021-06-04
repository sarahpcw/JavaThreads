package weekZ_10_threa;
import java.util.concurrent.Semaphore;
/*// A Semaphore is a thread synchronization construct 
that can be used either to send signals between threads to
avoid missed signals, 
or to guard a critical section like you would with a lock. 
*/
public class lesson9e_semaphores2 {
	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(1);
		System.out.println("Available permits " + sem.availablePermits() );
		sem.release();  // increase the available permits
		System.out.println("Available permits " + sem.availablePermits() );
		sem.release();
		System.out.println("Available permits " + sem.availablePermits() );
		sem.release();
		System.out.println("Available permits " + sem.availablePermits() );
		sem.acquire(); //aquire will wait until there is a permit available
		System.out.println("Available permits " + sem.availablePermits() );
		sem.acquire();
		System.out.println("Available permits " + sem.availablePermits() );
		sem.acquire();
		System.out.println("Available permits " + sem.availablePermits() );
		
		// because the aquire waits for an available permit
		// a sem with 1 permit andaquire works like a lock and unlock
	} //main
}//class
