package weekZ_10_threa;
//What is a thread group:
//https://www.infoworld.com/article/2074481/java-101--understanding-java-threads--part-4---thread-groups--volatility--and-threa.html
public class lesson6_Groups implements Runnable{
	private static int count = 0;
	private synchronized void increment(){
		count++;
	}
	 public void run(){  
		   System.out.println("running thread name is:"+Thread.currentThread().getName());  
		   System.out.println("running thread priority is:"+Thread.currentThread().getPriority());  
		   for ( int i=0; i<1000; i++){
				//count++;  // count = count + 1;
				increment();
				if ( (i % 500) == 0) System.out.println(Thread.currentThread().getName() + " count " + i);
			}	
	 }  
   public static void main(String[] args) throws InterruptedException {  
	   lesson6_Groups runnable = new lesson6_Groups();  
          ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");  
            
          Thread t1 = new Thread(tg1, runnable,"one");  // add the t1 to the group
          t1.start();  
          Thread t2 = new Thread(tg1, runnable,"two");  
          t2.start();  
          Thread t3 = new Thread(tg1, runnable,"three");  
          t3.start();  
               
         tg1.list();  
         System.out.println("Thread getMaxPriority(): "+tg1.getMaxPriority());
         System.out.println("Thread isDaemon(): "+tg1.isDaemon());
         System.out.println("Thread isDestroyed(): "+tg1.isDestroyed());
         System.out.println("Thread Group Name: "+tg1.getName());   
        
         t1.join();
         t2.join();
         t3.join();
         System.out.println("at the end " + count);
         System.out.println("active thread count " + tg1.activeCount()); 
   }  
}
/*
 * A thread pool is a collection of threads on which task can be scheduled. 
 * Instead of creating a new thread for each task, you can have one of the
 * threads from the thread pool pulled out of the pool and assigned to the task
 */

