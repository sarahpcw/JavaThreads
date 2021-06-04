package weekZ_10_threa;

public class lesson8 extends Thread{  
		  public void run(){  
		   System.out.println("running...");  
		  }  
		private void mstatement() {
		        System.out.println("method attached to thread " );       
		}
		 public static void main(String args[]){  
			 lesson8 t1=new lesson8();  
			 lesson8 t2=new lesson8();  
		  
		  System.out.println("Name of t1:"+t1.getName());  
		  System.out.println("Name of t2:"+t2.getName());  
		  System.out.println("id of t1:"+t1.getId());  
		  
		  t1.start();  
		  t2.start();  
		  t1.mstatement();
		  
		  t1.setName("Sonoo Jaiswal");  
		   
		  System.out.println("After changing name of t1:"+t1.getName());  
		 }  

	
		}
