package weekZ_10_threa;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// put and wait waits for each other , ie auto synched 
// because the blocking queue is synched, in the concurrent package
// also if the queue is full, put will wait till a value is taken
// take will
// producer : produce shared resource (queue)
// consumer : uses the shared resource in threads, ie sync important
public class lesson9a_ProducerConsumer {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new Runnable() {
			public void run (){
				try {producer();}catch (InterruptedException e){}
			}//run
		});
		Thread t2 = new Thread(new Runnable() {
			public void run (){
				try {consumer();}catch (InterruptedException e){}
			}//rin
		});
		t1.start();
		t2.start();
		t1.join();  // see throw declaration at method level
		t2.join();
		// click the red button to stop, the whiles are infinite
	}	
	public static void producer() throws InterruptedException{
		Random random = new Random();
		while(true){
			queue.put(random.nextInt(100)); 
			// put will wait for removal, because it cannot add more than 10 items
			
		}
	}
	public static void consumer() throws InterruptedException{
		Random random = new Random();
		while(true){
			Thread.sleep(100); // do something with eth taken value
			if (random.nextInt(10) == 0 ){ //take only every tenth time
			  Integer value = queue.take(); // take waits for put to complete ( synchronised)
			  System.out.println("Taken value: " + value + " Queue size: " + queue.size());
			}
		}
	}
	
}
