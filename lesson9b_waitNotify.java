package weekZ_10_threa;
// here the produce and consume is just used to demo wait and notify
// i.e. they are just 2 methods running in different threads
import java.util.Scanner;

public class lesson9b_waitNotify {
    private final Object lock1 = new Object(); //creates an empty object
    private final Object lock2 = new Object();
    
	public  void produce() throws InterruptedException{
		 synchronized (this){  // synchronize always need an object ( any object)
			 // synchronizes on the class itself (class lesson9b_waitNotify)
			 // uses the intrinsic lock of the class itself, ie only one
			 System.out.println("Producer thread running ...");
			 wait();   // relinqishes the lock
			 // causes the synchronize block to lose control on the code block
			 // can only run in a synchronised block 
			 System.out.println("Resumed ...");
		 }
	}

	public  void consume() throws InterruptedException{
		Scanner s = new Scanner (System.in); // the different objects of scanner are thread safe
		Thread.sleep(2000);  // waits so that the other will kick off first
		synchronized (this){ // both using the same lock
			System.out.println("Wait for return key to be pressed ....");
			String m = s.nextLine();
			System.out.println("Return key pressed ...");
			notify();   
			// can only be called from a synchronised block, there are 2 types of notify
			// it notifies the first wait on the same lock
			// it tells wait() to wake up, but the the producer can still not resumer, 
			// only after the whole consumer is completed , i.e. after waitin 2000ms
			// should really be just above the close bracket, because wait waits for the notify AND for the consumer to stop
			// Thread.sleep(5000); at this position will prove that the resume will not print for 5 seconds, it waits for all the code in consumer to be completed
		 } // at this curly bracket the notify command relinquishes the lock
	}
}  
// https://stackoverflow.com/questions/5824314/java-find-image-on-screen
//https://sqa.stackexchange.com/questions/16387/help-finding-image-in-sikuli-x-in-java
