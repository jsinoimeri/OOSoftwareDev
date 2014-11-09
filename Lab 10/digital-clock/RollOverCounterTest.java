import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RollOverCounterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RollOverCounterTest
{
    private RollOverCounter minutes;
    private RollOverCounter hours;
    
    /**
     * Default constructor for test class RollOverCounterTest
     */
    public RollOverCounterTest()
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
        hours = new RollOverCounter(0, 23, null);
        minutes = new RollOverCounter(0, 59, hours);
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
        assertEquals(0, hours.getCount());
        assertEquals(0, minutes.getCount());
        
        /* Increment the minutes from 0 to 59, inclusive. */
        for (int i = 1; i <= 59; i += 1) {
            minutes.countUp();
            assertEquals(i, minutes.getCount());
            
            /* hours should remain 0 until minute wraps around to 0. */
            assertEquals(0, hours.getCount());
        }
        
        /* Increment the time from 00:59 to 01:00. */
        minutes.countUp();
        assertEquals(0, minutes.getCount());
        assertEquals(1, hours.getCount());
    }
    
    @Test
    public void testToString()
    {
        assertEquals("00", hours.toString());
        for (int i = 1; i <= 9; i += 1)
            hours.countUp();
        assertEquals("09", hours.toString()); 
        hours.countUp();
        assertEquals("10", hours.toString()); 
    }
}
