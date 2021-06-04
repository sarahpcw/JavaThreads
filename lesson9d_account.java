package weekZ_10_threa;
public class lesson9d_account { 
	private int balance = 10000;
	public void deposit (int amount){
		balance += amount;
	}
	public void withdraw (int amount){
		balance -= amount;
	}
	public int getBalance(){
		return balance;
	}
	public static void transfer (lesson9d_account acc1, lesson9d_account acc2, int amount ){
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}
