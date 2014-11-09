import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChequingAccountTest.
 *
 * @author  D.L. Bailey, SCE
 * @version 1.00 March 24, 2009
 * @version 1.01 February 24, 2012 - converted to JUnit 4
 */
public class ChequingAccountTest
{
    private ChequingAccount acct;
    
    /**
     * Default constructor for test class ChequingAccountTest
     */
    public ChequingAccountTest()
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
        acct = new ChequingAccount(0.0);        
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
		acct = new ChequingAccount(100.0);
		assertEquals(100.0, acct.getBalance(), 0.001);		
	}

	/**
	 * Verify that the inherited deposit method works.
	 */
	@Test
	public void testDeposit()
	{
		acct.deposit(100.0);
		assertEquals(100.0, acct.getBalance(), 0.001);
		acct.deposit(200.00);
		assertEquals(300.0, acct.getBalance(), 0.001);
	}

	@Test
	public void testWithdrawal()
	{
		acct.deposit(1000.00);  // balance == 1000.0
		acct.withdraw(400.00);  // 1st withdrawal, balance = 600.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.deposit(200.00);  // balance == 800.0
		assertEquals(800.0, acct.getBalance(), 0.001);		
		acct.withdraw(100.00);  // 2nd withdrawal, balance = 700.0
		assertEquals(700.0, acct.getBalance(), 0.001);
		acct.withdraw(100.00);  // 3rd withdrawal, balance = 600.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.withdraw(100.00);  // 4th withdrawal, balance = 499.0
		assertEquals(499.0, acct.getBalance(), 0.001);
		acct.withdraw(50.00);   // 5th withdrawal, balance = 448.0
		assertEquals(448.0, acct.getBalance(), 0.001);			
    }
    
	@Test
	public void testMonthEnd()
	{
		acct.deposit(1000.00);  // balance == 1000
		acct.withdraw(400.00);  // 1st withdrawal, balance = 600.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.deposit(200.00);  // balance == 800.0
		assertEquals(800.0, acct.getBalance(), 0.001);		
		acct.withdraw(100.00);  // 2nd withdrawal, balance = 700.0
		assertEquals(700.0, acct.getBalance(), 0.001);
		acct.withdraw(100.00);  // 3rd withdrawal, balance = 600.0
		assertEquals(600.0, acct.getBalance(), 0.001);
		acct.withdraw(100.00);  // 4th withdrawal, balance = 499.0
		assertEquals(499.0, acct.getBalance(), 0.001);
		
		acct.monthEnd();       // 3 more free withdrawals
		assertEquals(499.0, acct.getBalance(), 0.001);
		acct.withdraw(50.00);  // 1st withdrawal, balance = 449.0
		assertEquals(449.0, acct.getBalance(), 0.001);
		acct.withdraw(10.00);  // 2nd withdrawal, balance = 439.0
		assertEquals(439.0, acct.getBalance(), 0.001);
		acct.withdraw(20.00);  // 3rd withdrawal, balance = 419.0
		assertEquals(419.0, acct.getBalance(), 0.001);		
		acct.withdraw(100.00);  // 4th withdrawal, balance = 318.0
		assertEquals(318.0, acct.getBalance(), 0.001);			
	}
}
