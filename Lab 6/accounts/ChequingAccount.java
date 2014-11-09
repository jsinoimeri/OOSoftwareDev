
/**
 * Models a chequing account with up to
 * three withdraws
 * 
 * @author Jeton Sinoimeri
 * @version Oct 27, 2013
 *
 */

public class ChequingAccount extends BankAccount
{
	
	private final double TRANSACTIONFEE = 1;
	
	private int withdraw_times;
	
	/**
	 * Constructs new chequing account with initial amount and
	 * zero number of withdraws.
	 * @param amount
	 * 
	 */
	
	public ChequingAccount(double amount)
	{
		super(amount);
		this.withdraw_times = 0;
	}
	
	
	/**
	 * Withdraws amount from account and if number of
	 * transactions is over limit then transaction fee is applied.
	 * @param amount
	 * 
	 */
	
	public void withdraw(double amount)
	{
		if(this.withdraw_times >= 3) { super.withdraw(amount + this.TRANSACTIONFEE); }
		
		else
		{
			this.withdraw_times ++;
			super.withdraw(amount);
		}
	}
	
	
	/**
	 * Resets the number of transactions to zero at
	 * month's end.
	 * 
	 */
	
	public void monthEnd()
	{
		this.withdraw_times = 0;
	}
}
