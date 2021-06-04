package weekZ_10_threa;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lesson9d_deadlock_version2 {
	private lesson9d_account acc1 = new lesson9d_account();
	private lesson9d_account acc2 = new lesson9d_account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock(); 
	private void acquirelocks(Lock firstLock, Lock secondLock)  throws InterruptedException{
		// to avoid deadlock, i.e. one threads tries to lock, but the other is holding the lock
		boolean gotFirstLock = false;
		boolean gotSecondLock= false;
		try{
		gotFirstLock = firstLock.tryLock();
		gotSecondLock = secondLock.tryLock();
		}
		finally {
			if (gotFirstLock && gotSecondLock){
				return;
			}
			if (gotFirstLock){
				firstLock.unlock();
			}
			if (gotSecondLock){
				secondLock.unlock();
			}	
			Thread.sleep(1);
		}
	}
	public  void firstThread() throws InterruptedException{ 
		Random random = new Random();
		acquirelocks(lock1,lock2);
		for (int i=0; i<10000; i++){
			try{
			  lesson9d_account.transfer(acc1, acc2, random.nextInt(100));
			}catch (Exception e){  }
			finally { 
				   lock1.unlock();
				   lock2.unlock();
			}
		}
	}
	public  void secondThread() throws InterruptedException{
		Random random = new Random(); 
		acquirelocks(lock1,lock2);
		for (int i=0; i<10000; i++) {
			try{
				lesson9d_account.transfer(acc2, acc1, random.nextInt(100));
			}catch (Exception e){ }
			finally {
				 lock1.unlock();
				 lock2.unlock();
			}
		}
	}
	public  void finished (){
		 System.out.println("account 1 " + acc1.getBalance());
		 System.out.println("account 2 " + acc1.getBalance());
		 System.out.println("Total " + (acc1.getBalance()+acc2.getBalance()));
	}
	
}  