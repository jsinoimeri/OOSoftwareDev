/**
 * This class implements an up-counter that counts factorials,
 * starting at 0!; in other words, it counts 0!, 1!, 2!, ..., 10!
 * The counter stops counting when it reaches 10!; that is, it 
 * must be reset 0! once it reaches 10!
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.00 Feb. 15, 2012
 */

public class FactorialCounter extends Counter
{
    private static final int TEN_FACTORIAL = 3628800;  // 10!
    private static final int ZERO_FACTORIAL = 1;
    
    private int factorial = ZERO_FACTORIAL;
    
    /**
     * Constructs a new FactorialCounter whose current count is
     * initialized to 0!; and which counts between 0! and 10!,
     * inclusive.
     */
    public FactorialCounter()
    {
        super(ZERO_FACTORIAL, TEN_FACTORIAL);
    }
    
    /**
     * Override parent getCount()
     * Returns factorial
     */    
    public int getCount() 
    { 
        return factorial; 
    }
    
    /**
     * Override parent reset
     */
    public void reset()
    {
        factorial = ZERO_FACTORIAL;
        super.reset();
    }

    /**
     * Increments this counter. Assuming that the current count is n!,
     * 0 <= n <= 9, this method increments the counter to (n + 1)!
     */
    
    public void countUp()
    {
        if (factorial < maximumCount())
        {   
            factorial *= super.getCount();
            super.countUp();
        }
    }  
}
