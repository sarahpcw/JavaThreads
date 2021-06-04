package weekZ_10_threa;
/*Re-entrant lock
	can be locked many times, and then must be unlocked the same number of times
	used instead of sycnhronising a block of code
*/


/*Condition factors out the Object monitor methods (wait, notify and 
 * notifyAll) into distinct objects to give the effect of having multiple 
 * wait-sets per object, by combining them with the use of arbitrary Lock 
 * implementations. Where a Lock replaces the use of synchronized methods 
 * and statements, a Condition replaces the use of the Object monitor 
 * methods.
Conditions (also known as condition queues or condition variables) 
provide a means for one thread to suspend execution (to "wait") until 
notified by another thread that some state condition may now be true. 
Because access to this shared state information occurs in different threads,
 it must be protected, so a lock of some form is associated with the
  condition. The key property that waiting for a condition provides is
   that it atomically releases the associated lock and suspends the 
   current thread, just like Object.wait.

A Condition instance is intrinsically bound to a lock. To obtain a 
Condition instance for a particular Lock instance use its newCondition() 
method.*/

import java.util.Scanner;
import java.util.concurrent.locks.Condition; // needed for wait and noify on a lock
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lesson9c_reentrantLock_1 {
	
	private Lock lock = new ReentrantLock();
	private Condition cond =  lock.newCondition(); 
	//Condition class has the await and signal methods ( instead of wait and notify when using re-entrant lock)

	private int count = 0;
	
	public void increment(){
		for ( int i =0; i<20000; i++){
			count++;
		}
	}
	// the 2 threads interfere with the incrementing of count and end with 
	// sometimes overwriting the others update , so the answer is not 40000
	// by locking , the one thread locks it , do all its increments and then the other starts
	public  void firstThread() throws InterruptedException{
		lock.lock(); // can only wait or notify after lock
		System.out.println("Waiting ....");
		cond.await(); // releases the lock and lock is handed over
		System.out.println("Woken up!!");
		increment(); 
		
	    lock.unlock();
		// only one thread can lock at a time
	}

	public  void secondThread() throws InterruptedException{
		Thread.sleep(1000); // wait so that the other starts first
		lock.lock();
		System.out.println("Press the return key");
		new Scanner(System.in).nextLine(); // quick code to wait for you to press enter	
		System.out.println("Go the return key");
		cond.signal(); // wakes up 1 waiting thread, the one that took the lock first
		increment(); 
		
		lock.unlock(); 
		// must do signal AND unlock for the woken up thread to resume
		// only one thread can lock at a time
	}  
	
	public  void finished (){
		System.out.println("count " + count);
	}
	
}  