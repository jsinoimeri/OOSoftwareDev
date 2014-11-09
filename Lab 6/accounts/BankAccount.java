
/**
 * Models a Bank Account
 * 
 * @author Jeton Sinoimeri
 * @version Oct 27, 2013
 *
 */

public class BankAccount
{

	private double balance;
	
	/**
	 * Constructs a new BankAccount with initial amount
	 * @param amount
	 * 
	 */
	
	public BankAccount(double amount)
	{
		this.balance = amount;
	}
	
	
	/**
	 * Deposits amount into the account
	 * @param amount
	 * 
	 */
	
	public void deposit(double amount)
	{
		this.balance += amount;
	}
	
	
	/**
	 * Withdraws amount from the account.
	 * @param amount
	 * 
	 */
	
	public void withdraw(double amount)
	{
		this.balance -= amount;
	}
	
	/**
	 * Returns the current balance of the account.
	 * @return double
	 * 
	 */
	
	public double getBalance()
	{
		return this.balance;
	}
}
