package weekZ_10_threa;
// re-entrant lock is an alternative to synchronized keyword
public class lesson9d_deadlockRun {
	public static void main(String[] args) throws InterruptedException {
		final lesson9d_deadlock proc  = new lesson9d_deadlock();
		//final lesson9d_deadlock_version2 proc  = new lesson9d_deadlock_version2();
			Thread t1 = new Thread(new Runnable (){
				public void run(){
//					try {
						proc.testDead();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			});
			Thread t2 = new Thread(new Runnable (){
				public void run(){
//					try {
						proc.testDead();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			proc.finished();
			

		
	} //main
		
		

}//class
