package weekZ_10_threa;

public class lesson9b_waitNotifyRun {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		final lesson9b_waitNotify proc  = new lesson9b_waitNotify();
		
			Thread t1 = new Thread(new Runnable (){
				public void run(){
					try {
						proc.produce();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			Thread t2 = new Thread(new Runnable (){
				public void run(){
					try {
						proc.consume();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			

		
	} //main
		
		

}//class
