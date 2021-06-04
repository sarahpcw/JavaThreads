package weekZ_10_threa;
// ThreadGroupDemo.jav
public class lesson6_GroupsDemo {
/*
 * The activeCount() method of ThreadGroup class is used 
 * to return the number of active threads in the current thread's thread group.
 *  The returned value is only an estimate because the number of threads may 
 *  change dynamically 
 * while this method traverses internal data structures.
 * 
 * The java.lang.Thread.getThreadGroup() method returns the thread 
 * group to which this thread belongs. 
 * It returns null if this thread has died (been stopped).
 */
	   public static void main (String [] args)
	   {
	      ThreadGroup tg = new ThreadGroup ("subgroup 1");
	      Thread t1 = new Thread (tg, "thread 1");
	      Thread t2 = new Thread (tg, "thread 2");
	      Thread t3 = new Thread (tg, "thread 3");
	      tg = new ThreadGroup ("subgroup 2");
	      Thread t4 = new Thread (tg, "my thread");
	      tg = Thread.currentThread().getThreadGroup(); 
	      int agc = tg.activeGroupCount();//how many threads in the group
	      System.out.println ("Groupname: " + tg.getName () +
	                          ", and Nr of threads in thread group: " + agc);
	      System.out.println("-- .list() does this: --");
	      tg.list ();
	      System.out.println("-- .list() all done --");
	      
	   }
	}
