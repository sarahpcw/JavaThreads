package weekZ_10_threa;

public class lesson4Priotiries  extends Thread{  
	public void run(){  
	   System.out.println("running thread name is:"+Thread.currentThread().getName());  
	   System.out.println("running thread priority is:"+Thread.currentThread().getPriority());  
	}
	public static void main(String args[]){ 

		lesson4Priotiries m0=new lesson4Priotiries();  
		lesson4Priotiries m1=new lesson4Priotiries(); 
		lesson4Priotiries m2=new lesson4Priotiries(); 
		lesson4Priotiries m3=new lesson4Priotiries(); 
		
		System.out.println(m0.getName());
		
		m0.setPriority(Thread.NORM_PRIORITY);   //5
		m3.setPriority(Thread.NORM_PRIORITY);   //5
		m1.setPriority(Thread.MAX_PRIORITY);  //10
		m2.setPriority(Thread.MIN_PRIORITY);  //1

		m0.start(); 
		m1.start(); 
		m2.start();
		m3.start();
		   
	}
}
