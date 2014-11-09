/**
 * SYSC 2004 A Fall 2013 Lab 2
 */

/** A Heater models a simple space-heater. The operations provided by a Heater
 * object are:
 * 1. Increase and decrease the temperature setting by a set amount. (Part 1)
 *    The heaters temperature cannot be raised above a specified maximum
 *    value or lowered below a specified minimum value. (Part 2)
 * 2. Return the current temperature setting. (Part 1)
 * 3. Change the set amount by which the temperature is increased 
 *    and lowered to a specified non-negative value. (Part 2)
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.01 January 13, 2007
 * @version 1.02 March 23, 2011
 * @version 1.03 January 11, 2012
 */

public class Heater 
{
    /** The temperature setting that the heater should maintain. */
    
    // Declare the field named temperature here.
	private int temperature,
				increment_temp,
				min_temp,
				max_temp;
	
           
    /**
     * Constructs a new Heater with an initial temperature setting of 15
     * degrees, and which increments and decrements the temperature
     * setting in increments of 5 degrees (see methods warmer and cooler). 
     */
    public Heater(int minTemp, int maxTemp)
    {
    	this.temperature = 15;
    	this.min_temp = minTemp;
    	this.max_temp = maxTemp;
    	this.increment_temp = 5;
    }

    /**
     * Returns this heater's current temperature setting.
     */    
    public int getTemperature()
    {
        return this.temperature;
    }
    
    /**
     * Increases the heater's temperature setting by 5.
     */
    public void warmer()
    {
    	if ((this.temperature + this.increment_temp) <= this.max_temp) 
    	    this.temperature += this.increment_temp;
    		
    }

    /**
     * Lowers the heater's temperature setting by 5.
     */   
    public void cooler()
    { 
    	if ((this.temperature - this.increment_temp) >= this.min_temp)
    		this.temperature -= this.increment_temp;
    }
    
    // setIncrement is implemented in Part 2.
    
    /**
     * Sets the temperature increment used by warmer() and cooler() 
     * to the specified value. Has no effect if newIncrement is not
     * positive.
     */        
    public void setIncrement(int newIncrement)
    {
             
    	if (newIncrement > 0)
    		this.increment_temp = newIncrement;
    }       
}

