package weekZ_10_threa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lesson7_theadpoolapp1_test {
	
    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();
    static Random random = new Random();
    
    public static void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void stageOne() {
             try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                //do your work here
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
    }
    

    public static void stageTwo() {
       
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                //do your work here
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
     
    }

	public static void main(String[] args) {
	       System.out.println("Starting ...");
	        long start = System.currentTimeMillis();
	        
		process();
		process();
	      
		long end = System.currentTimeMillis();    
	        System.out.println("End  : Time taken: " + (end - start));
	        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	  
	}

}
