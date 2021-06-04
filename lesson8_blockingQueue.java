package weekZ_10_threa;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*
 * 2threads adding and taking from the arrayblocking queue
 *  which is synchronized 
 *  they add and take simultaneously, synchonised
 *  avoiding having to use low level manual synchcronisation
 */
//check the reason for the queu not getting more

public class lesson8_blockingQueue {
	// synchronized!!!
	private static BlockingQueue<Integer> q =  new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable (){
			public void run(){
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable (){
			public void run(){
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}
	
	public static void producer() throws InterruptedException{
		Random r = new Random();
		int count =0;
		while (count < 100){
			q.put(r.nextInt(100));
			System.out.println("put " + q.size()); 
			count++;
		}
	}

	public static void consumer() throws InterruptedException{
		Random r = new Random();
		int count = 0;
		Thread.sleep(100);
		while (count<100){			
			if (r.nextInt(10) == 0){ //simulate prcessing
				Integer value = q.take();
				System.out.println("Taken " + value + " Queue size " + q.size());				
			}
			count++;
		}
	}
	
}
