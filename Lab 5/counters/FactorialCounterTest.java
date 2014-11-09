import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FactorialCounterTest.
 *
 * @author  D.L. Bailey, SCE, Carleton U.
 * @version 1.00 Feb 15, 2012
 */
public class FactorialCounterTest
{
    private FactorialCounter counter;
    
    /**
     * Default constructor for test class FactorialCounterTest
     */
    public FactorialCounterTest()
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
        counter = new FactorialCounter();
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
    public void testCountUp()
    {
        // The initial value of the counter should be 0! (1).        
        int expected = 1;
        assertEquals(expected, counter.getCount());
        
        // Verify that the counter counts from 0! to 10!, inclusive.
        for (int n = 1; n <= 10; n += 1) {
            expected = expected * n;
            counter.countUp();
            assertEquals(expected, counter.getCount());
        }
    }
    
    @Test
    public void testReset()
    {
        for (int i = 0; i < 3; i += 1) {
            counter.countUp();
        }
        counter.reset();
        assertTrue(counter.isAtMinimum());
        
        counter.countUp();  // 0! -> 1!
        assertEquals(1, counter.getCount());
        
        counter.countUp();  // 1! -> 2!
        assertEquals(2, counter.getCount());
        
        counter.countUp();   // 2! -> 3!
        assertEquals(6, counter.getCount());
    }           
}
