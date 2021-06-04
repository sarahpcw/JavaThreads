package weekZ_10_threa;

import java.util.Random;

public class threadExample implements Runnable{

		String name;  
		int time; 
		Random r = new Random ();

		public threadExample(String s){
			name = s;
			time = r.nextInt(99999);
		} //constructor
		
		public void run(){ //will run when we start ur code

			try{
				System.out.printf("%s is sleeping for %d", name + time + "\n");
				Thread.sleep(time);
				System.out.printf("%s this is done ", name + "\n");
			}
			catch (Exception e){
					//System.out.println("this is boo ", name);
			}

		}//run
		
	}//class

