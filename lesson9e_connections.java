package weekZ_10_threa;

import java.util.concurrent.Semaphore;

public class lesson9e_connections {
	private static lesson9e_connections instance = new lesson9e_connections();
	private int connections = 0;
	private Semaphore sem  = new Semaphore(10);
	
	private lesson9e_connections(){ // singleton9private constructor)
		
	}
	public static lesson9e_connections getInstance(){
		return instance;
	}
	public void connect() {
		// by using semaphore , their can only be 10 acquires
		try { // test by removing aquire and release
			sem.acquire();
		} catch (InterruptedException e1) { 
			e1.printStackTrace();
		}
		synchronized (this){
			connections++;
			System.out.println("connections " + connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		synchronized (this){
			connections--;
		}
		sem.release();
	}
}
