package weekZ_10_threa;
// re-entrant lock is an alternative to synchronized keyword
public class lesson9c_reentrantLockRun {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		final lesson9c_reentrantLock_1 proc  = new lesson9c_reentrantLock_1();
		
			Thread t1 = new Thread(new Runnable (){
				public void run(){
					try {
						proc.firstThread();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			Thread t2 = new Thread(new Runnable (){
				public void run(){
					try {
						proc.secondThread();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			proc.finished();
			

		
	} //main
		
		

}//class
