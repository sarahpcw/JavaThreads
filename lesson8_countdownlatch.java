package weekZ_10_threa;
// countdownlatch is a synchronised integer 
// so only one thread can access it at a time
/**
 * {@link java.util.concurrent.CountDownLatch} Java class to synchronize your threads’ activities.
 * <br><br>
 * Source:
 * <em>http://stackoverflow.com/questions/17827022/what-is-countdown-latch-in-java-multithreading</em><br>
 *
 * Any thread, usually main thread of application, which calls
 * {@link java.util.concurrent.CountDownLatch#await()} will wait until count reaches zero or its interrupted
 * by another thread. All other thread are required to do count down 
 * by calling
 * {@link java.util.concurrent.CountDownLatch#countDown()} once they are 
 * completed or ready.
 * <br>
 * As soon as count reaches zero, Thread awaiting starts running. One of the
 * disadvantage of {@link java.util.concurrent.CountDownLatch} is that it's
 * not reusable once the count reaches to
 * zero you can not use {@link java.util.concurrent.CountDownLatch} any more.
 * <br><br>
 * Use {@link java.util.concurrent.CountDownLatch} when one thread, like main
 * thread, require to wait for one or more threads to complete, before it can
 * start processing.
 * <br><br>
 * Classical example of using {@link java.util.concurrent.CountDownLatch} in
 * Java is any server side core  Java application which uses services
 * architecture, where multiple services
 * are provided by multiple threads and application can not start processing
 * until all services have started successfully.
 * <br><br>
 * Codes with minor comments are from <em>http://www.caveofprogramming.com/youtube/</em><br>
 * also freely available at
 * <em>https://www.udemy.com/java-multithreading/?couponCode=FREE</em>
 *
 * @author Z.B. Celik <celik.berkay@gmail.com>
 */
import java.util.concurrent.CountDownLatch;

class lesson8_countdownlatch implements Runnable {
//class Processor implements Runnable {

    private CountDownLatch latch;
    int count = 3;
    public lesson8_countdownlatch(CountDownLatch latch) {  //every thread decrements , threadsafe
        this.latch = latch;
        
    }

    public void run() {
    	
        System.out.println("Started.");
        System.out.println("Before latch value: " + latch.getCount() + " Name " + Thread.currentThread().getName() );
        try {
            Thread.sleep(3000); // do something usefull
        } catch (InterruptedException ignored) {}
        count--;
        latch.countDown(); //latch = latch-1; or latch--;
        System.out.println("After latch value: " + latch.getCount() 
        		+ " count " + count
        		+  " thread name:"+ Thread.currentThread().getName() );  
  	  
    }
}

