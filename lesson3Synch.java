package weekZ_10_threa;

public class lesson3Synch {

	public void send(String msg) 
    { 
       // synchronized(this){
            
            System.out.println("Sending\t" + msg ); 
            try 
            { 
                Thread.sleep(1000); 
            }  
            catch (Exception e)  
            { 
                System.out.println("Thread interrupted."); 
            } 
            System.out.println("\n" + msg + "Sent"); 
       // } 
    }
}
