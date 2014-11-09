
/**
 * Models Savings Account
 * 
 * @author Jeton Sinoimeri
 * @version Oct 27, 2013
 *
 */

public class SavingsAccount extends BankAccount
{

	private double interestRate,
				   minBalance;
	
	/**
	 * Constructs Savings account instance with
	 * initial amount and zero interest rate
	 * @param amount
	 * 
	 */
	
	public SavingsAccount(double amount)
	{
		super(amount);
		this.minBalance = amount;
		this.interestRate = 0;
	}
	
	
	/**
	 * Withdraws amount from account
	 * @param amount
	 * 
	 */
	
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		
		if (this.minBalance > this.getBalance()) { this.minBalance = this.getBalance(); }
	}
	
	
	/**
	 * Sets the monthly interest rate
	 * @param rate
	 * 
	 */
	
	public void setInterestRate(double rate)
	{
		this.interestRate = rate;
	}
	
	
	/**
	 * Deposits the interest earned on the minimum balance
	 * of the account during the month.
	 * 
	 */
	
	public void monthEnd()
	{
		this.deposit(this.minBalance * (this.interestRate/100));
		
		this.minBalance = this.getBalance();
	}
}
