package weekZ_10_threa;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lesson9d_deadlock {
	private lesson9d_account acc1 = new lesson9d_account();
	private lesson9d_account acc2 = new lesson9d_account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock(); 
	public  void firstThread() throws InterruptedException{ 
		Random random = new Random();
		lock1.lock(); //test with out the locks
		//lock2.lock();
		for (int i=0; i<100; i++){
			 
			lesson9d_account.transfer(acc1, acc2, random.nextInt(100));
			 
			lock1.unlock();
				  // lock2.unlock();
			 
		}
	}
	public  void secondThread() throws InterruptedException{
		Random random = new Random(); 
		lock1.lock();  
		// if the lock1 and and lock2 is locked in reverseorder
		// there may be a deadlco
		//lock2.lock();
		for (int i=0; i<100; i++) {
			try{
				lesson9d_account.transfer(acc2, acc1, random.nextInt(100));
			}catch (Exception e){ }
			finally {
				 lock1.unlock();
				// lock2.unlock();
			}
		}
	}
	public void testDead(){
		lock1.lock();
		while(true){
		
			 System.out.println("running thread name is:"+Thread.currentThread().getName());  
			 
		}	
	}	
	
	public  void finished (){
		 System.out.println("account 1 " + acc1.getBalance());
		 System.out.println("account 2 " + acc2.getBalance());
		 System.out.println("Total " + (acc1.getBalance()+acc2.getBalance()));
	}
	
}  