

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalariedEmployeeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalariedEmployeeTest
{
    private SalariedEmployee salaried1;

    /**
     * Default constructor for test class SalariedEmployeeTest
     */
    public SalariedEmployeeTest()
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
        salaried1 = new SalariedEmployee("Cathy Coder", 123456);
        salaried1.setAnnualSalary(60000);        
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

    @Test
    public void testCalculatePay()
    {
        assertEquals(2307.69, salaried1.calculatePay(), 0.1);
        salaried1.setAnnualSalary(52000);        
        assertEquals(2000.00, salaried1.calculatePay(), 0.1);
    }

    @Test
    public void testToString()
    {
        assertEquals("Cathy Coder: 123456", salaried1.toString());
    }

    @Test
    public void testEquals()
    {       
        SalariedEmployee salaried2 = new SalariedEmployee("Cathy Coder", 123456);
        salaried2.setAnnualSalary(60000);
        assertEquals(true, salaried1.equals(salaried2));
        assertEquals(false, salaried1.equals(null));
        assertEquals(true, salaried1.equals(salaried1));
        
        HourlyEmployee hourlyEm1 = new HourlyEmployee("Harry Hacker", 111222);
        hourlyEm1.setHoursWorked(15);
        hourlyEm1.setHoursWorked(20);
        
        assertEquals(false, salaried1.equals(hourlyEm1));
    }
}



