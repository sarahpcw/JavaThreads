package weekZ_10_threa;

public class lesson7_threadPool_app3  implements Runnable{
	   private String message;  
	   public lesson7_threadPool_app3(String s){  
	        this.message=s;  
	   }  
	   public void run() {  
	        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
	        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
	        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
	   }  
	   private void processmessage() {
		  
	        try {  
	        	Thread.sleep(2000);  
	        } catch (InterruptedException e) { e.printStackTrace(); }  
	   }
	}
