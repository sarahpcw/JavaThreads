package weekZ_10_threa;
/*
 * Thread pools address two different problems: 
 * they usually provide improved performance when executing 
 * large numbers of asynchronous tasks, due to reduced per-task 
 * invocation overhead, and they provide a means of bounding and 
 * managing the resources, including threads, consumed when executing a 
 * collection of tasks. Each ThreadPoolExecutor also maintains some 
 * basic statistics, 
 * such as the number of completed tasks.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class lesson7_threadpool_app1 implements Runnable{

//	class Worker implements Runnable {
 
	    private Random random = new Random();
	    private final Object lock1 = new Object();
	    private final Object lock2 = new Object();
	    public List<Integer> list1 = new ArrayList<>();
	    public List<Integer> list2 = new ArrayList<>();

	    @Override
	    public void run() {
	        process();
	        System.out.println("Thread name " + Thread.currentThread().getName());
	        System.out.println("List 1 " + list1.size() + "List 2 " + list2.size());
	    }

	    public void process() {
	        for (int i = 0; i < 1000; i++) {
	            stageOne();
	            stageTwo();
	        }
	    }

	    public void stageOne() {
	        synchronized (lock1) {
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                //do your work here
	                e.printStackTrace();
	            }
	            list1.add(random.nextInt(100));
	        }
	    }

	    public  void stageTwo() { 
	        synchronized (lock2) {
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                //do your work here
	                e.printStackTrace();
	            }
	            list2.add(random.nextInt(100));
	        }
	    }
	
	} //lesson7_threadpool_app1

	