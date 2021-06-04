package weekZ_10_threa;
/*
 * Daemon thread is a low priority thread that runs in background 
 * to perform tasks such as garbage collection.
 *  Properties: They can not prevent the JVM from exiting when all the 
 *  user threads finish their execution. ... If JVM finds 
 * running daemon thread, it terminates the thread and after that
 *  shutdown itself.
 */
public class lesson5_Deamon extends Thread{
  public void run(){   
	if(Thread.currentThread().isDaemon()){//checking for daemon thread  
    	System.out.println("daemon thread work");  
    }  
    else{  
	  	System.out.println("user thread work");  
    }  
 }  
 
  public static void main(String[] args){  
	 lesson5_Deamon t1=new lesson5_Deamon();//creating thread  
	 lesson5_Deamon t2=new lesson5_Deamon();  
	 lesson5_Deamon t3=new lesson5_Deamon();  
  
  t1.setDaemon(true);//now t1 is daemon thread  
    
  t1.start();//starting threads  
  t2.start();  
  t3.start();  
 }  
    
 
}
