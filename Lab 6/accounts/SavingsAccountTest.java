import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SavingsAccountTest.
 *
 * @author  D.L. Bailey, SCE
 * @version 1.00 March 24, 2009, 1.01 March 28, 2011
 * @version 1.02 February 24, 2012 - convert to JUnit 4
 */
public class SavingsAccountTest
{
    private SavingsAccount acct;
    
    /**
     * Default constructor for test class SavingsAccountTest
     */
    public SavingsAccountTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        acct = new SavingsAccount(0.0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Verify that the balance in a newly created account is 
     * the amount passed to the constructor.
     */
	@Test
	public void testGetBalance()
	{
		assertEquals(0.0, acct.getBalance(), 0.001);
		acct = new SavingsAccount(100.0);
		assertEquals(100.0, acct.getBalance(), 0.001);		
	}

	@Test
	public void testDeposit()
	{
		acct.deposit(100);
		assertEquals(100.0, acct.getBalance(), 0.001);
		acct.deposit(200.00);
		assertEquals(300.0, acct.getBalance(), 0.001);
	}
	
	@Test
	public void testWithdrawal()
	{
		acct.deposit(1000.00);  // balance == 1000.0, min balance == 0.0
		acct.withdraw(400.00);  // balance = 400.0, min balance == 0.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.deposit(200.00);  // balance == 800.0, min balance == 0.0
		assertEquals(800.0, acct.getBalance(), 0.001);		
		acct.withdraw(100.00);  // balance = 700.0, min balance == 0.0
		assertEquals(700.0, acct.getBalance(), 0.001);
    }

	@Test
	public void testMonthEnd()
	{
		acct.setInterestRate(1.0);
		acct.deposit(1000.00);  // balance == 1000.0, min balance == 0.0
		acct.withdraw(400.00);  // balance = 600.0, min balance == 0.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.monthEnd();       // no interest payable, because min balance == 0.0
		                       // min balance set to 600.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		
		acct.deposit(200.00);  // balance == 800.0, min balance == 600.0
		assertEquals(800.0, acct.getBalance(), 0.001);		
		acct.withdraw(100.00);  // balance = 700.0, min balance == 600.0
		assertEquals(700.0, acct.getBalance(), 0.001);
		acct.withdraw(200.00);  // balance = 500.0, min balance == 500.0
		assertEquals(500.0, acct.getBalance(), 0.001);	
		acct.deposit(100.00);  // balance == 600.0, min balance == 500.0
		assertEquals(600.0, acct.getBalance(), 0.001);		
		
		acct.monthEnd();       // interest payable = 1% of 500.0 = 5.0
		                       // balance == 605.0
		                       // min balance set to 605.0
		assertEquals(605.0, acct.getBalance(), 0.001);	
		
		acct.deposit(95.0); // balance == 700.0, min balance == 605.0
		acct.monthEnd();    // interest payable = 1% of 605.0 = 6.05
		                    // balance == 706.05
		                    // min balance set to 706.05
		assertEquals(706.05, acct.getBalance(), 0.001);		
	}
}



