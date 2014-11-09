/**
 * This class implements an up-counter that counts between a minimum value
 * and a maximum value, inclusive. When the counter reaches its maximum
 * value, it wraps around to its lower limit.
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.00 Feb. 14, 2012
 * @version 2.00 Mar. 28, 2012
 */


public class RollOverCounter
{  
    /** The current value of this counter. */
    private int count;

    /** The minimum value of this counter. */
    private int minimumCount;

    /** The maximum value of this counter. */
    private int maximumCount;

    /** The default minimum value of this counter. */
    private static final int DEFAULT_MINIMUM = 0;

    /** The default maximum value of this counter. */
    private static final int DEFAULT_MAXIMUM = 999;
    
    private RollOverCounter hours_mins;

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to DEFAULT_MINIMUM, and which counts between
     * DEFAULT_MINIMUM and DEFAULT_MAXIMUM, inclusive.
     */
    public RollOverCounter(RollOverCounter next)
    {
        this(DEFAULT_MINIMUM, DEFAULT_MAXIMUM, next);
    }

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     */
    public RollOverCounter(int minCount, int maxCount, RollOverCounter next)
    {
        this.minimumCount = minCount;
        this.maximumCount = maxCount;
        this.count = minimumCount;
        this.hours_mins = next;
    }

    /**
     * Returns the maximum value of this counter.
     * 
     * @return The counter's maximum value.
     */
    public int maximumCount()
    {
        return this.maximumCount;
    }

    /**
     * Returns the minimum value of this counter.
     * 
     * @return The counter's minimum value.
     */
    public int minimumCount()
    {
        return this.minimumCount;
    }

    /**
     * Returns this counter's current count.
     * 
     * @return The counter's current value.
     */
    public int getCount()
    {
        return this.count;
    }

    /**
     * Returns true if this counter is at its minimum value.
     * 
     * @return true if this counter is at it minimum value;
     * otherwise false.
     */
    public boolean isAtMinimum()
    {
         return (this.count == this.minimumCount);
    }

    /**
     * Returns true if this counter is at its maximum value.
     * 
     * @return true if this counter is at its maximum value;
     * otherwise false.
     */
    public boolean isAtMaximum()
    {
        return (this.count == this.maximumCount);
    }

    /**
     * Resets this counter to its minimum value.
     */
    public void reset()
    {
        this.count = this.minimumCount;
    }

    /**
     * Increments this counter by 1.
     */
    public void countUp()
    {
        // If we've reached the maximum count, invoking this
        // method rolls the counter over to its minimum value.
        if (this.count == this.maximumCount)
        {
            this.count = this.minimumCount;
            if (this.hours_mins != null) { this.hours_mins.countUp(); }
        } 
        
        else { this.count ++; } 
    }
    
    /**
     * Returns this counter's current count as a two-digit string.
     * If count is between 0 and 9, the string is padded with a leading 0; e.g.,
     * if the count is 4, this method returns "04".
     */
    public String toString()
    {
        return String.format("%02d", this.count);
    } 
}