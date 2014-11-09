import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CompanyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompanyTest
{
    private Company company;
    private SalariedEmployee salaried1;
    private HourlyEmployee hourlyEm1;

    /**
     * Default constructor for test class CompanyTest
     */
    public CompanyTest()
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
        company = new Company();
        salaried1 = new SalariedEmployee("Cathy Coder", 123456);
        salaried1.setAnnualSalary(60000);
        
        hourlyEm1 = new HourlyEmployee("Harry Hacker", 111222);
        hourlyEm1.setHoursWorked(15);        
        hourlyEm1.setHourlyWage(20);        
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
    public void testHireAndLookup()
    {
        SalariedEmployee salaried2 = new SalariedEmployee("Cathy Coder", 123456);
        salaried2.setAnnualSalary(60000); 
        
        HourlyEmployee hourlyEm2 = new HourlyEmployee("Harry Hacker", 111222);
        hourlyEm2.setHoursWorked(15);
        hourlyEm2.setHourlyWage(20);
        
        /* lookup should fail, because we haven't added any employees to the employee list. */
        assertEquals(false, company.lookupEmployee(salaried1));
        assertEquals(false, company.lookupEmployee(hourlyEm1));
        
        /* Adding salaried2 and hourlyEm2 to the employee list should fail, because we've already 
         * added employees with the same ID numbers.
         */
        assertEquals(true, company.addEmployee(salaried1));
        assertEquals(false, company.addEmployee(salaried2));
        assertEquals(true, company.addEmployee(hourlyEm1));
        assertEquals(false, company.addEmployee(hourlyEm2));        
        
        assertEquals(true, company.lookupEmployee(salaried2));
        assertEquals(true, company.lookupEmployee(hourlyEm2));
    }

    @Test
    public void testCalculatePayroll()
    {
        company.addEmployee(salaried1);
        company.addEmployee(hourlyEm1);
        assertEquals(2907.69, company.calculatePayroll(), 0.1);        
    }
}


