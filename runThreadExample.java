package weekZ_10_threa;

public class runThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		threadExample i = new threadExample ("h");
		threadExample j = new threadExample ("t");		
		i.run();
		j.run();
		i.run();

		j.run();
		i.run();
		j.run();

	}

}
