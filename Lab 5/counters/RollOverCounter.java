/**
 * This class implements an up-counter that counts between a minimum value
 * and a maximum value, inclusive. When the counter reaches its maximum
 * value, it wraps around to its minimum value.
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.00 Feb. 14, 2012
 * @version 1.01 Feb. 15, 2012
 */
public class RollOverCounter extends Counter
{
    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to Counter.DEFAULT_MINIMUM, and which counts between
     * Counter.DEFAULT_MINIMUM and Counter.DEFAULT_MAXIMUM, inclusive.
     */
    public RollOverCounter()
    {
        super();
    }

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     * 
     * @param minCount The lower limit for this counter.
     * @param maxCount The upper limit for this counter.
     */
    public RollOverCounter(int minCount, int maxCount)
    {
        super(minCount, maxCount);
    }

    /**
     * Increments this counter by 1.
     */
    public void countUp()
    {
        // If we've reached the maximum count, invoking this
        // method rolls the counter over to its minimum value.
        if (isAtMaximum()) {
            reset();
        } else {
            super.countUp();
        }
    }
}
