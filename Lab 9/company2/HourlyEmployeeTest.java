

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HourlyEmployeeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HourlyEmployeeTest
{
    private HourlyEmployee hourlyEm1;

    /**
     * Default constructor for test class HourlyEmployeeTest
     */
    public HourlyEmployeeTest()
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
        hourlyEm1 = new HourlyEmployee("Harry Hacker", 111222);
        hourlyEm1.setHoursWorked(15);        
        hourlyEm1.setHourlyWage(20.0);        
        assertEquals(600.0, hourlyEm1.calculatePay(), 0.1);        
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
        assertEquals(600.0, hourlyEm1.calculatePay(), 0.1);        
        hourlyEm1.setHoursWorked(20);
        hourlyEm1.setHourlyWage(30.0);        
        assertEquals(1200.0, hourlyEm1.calculatePay(), 0.1);
    }
    
    @Test
    public void testToString()
    {
        assertEquals("Harry Hacker: 111222", hourlyEm1.toString());
    } 
    
    @Test
    public void testEquals()
    {       
        HourlyEmployee hourlyEm2 = new HourlyEmployee("Harry Hacker", 111222);
        hourlyEm2.setHoursWorked(15);
        hourlyEm2.setHourlyWage(20.0);
        assertEquals(true, hourlyEm1.equals(hourlyEm2));
        assertEquals(false, hourlyEm1.equals(null));
        assertEquals(true, hourlyEm1.equals(hourlyEm1));
        
        SalariedEmployee salaried1 = new SalariedEmployee("Cathy Coder", 123456);
        salaried1.setAnnualSalary(60000);        
        
        assertEquals(false, hourlyEm1.equals(salaried1));
    }    
}

