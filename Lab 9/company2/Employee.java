
/**
 * SYSC 2004 Winter 2013 Lab 9.
 * 
 * Class Employee is the superclass for classes that 
 * model all types of employees.
 */
public abstract class Employee implements IEmployee
{
	private String name;
	private long id;
	
	public Employee(String name, long id)
	{
		this.name = name;
		this.id = id;
	}
	
    /**
     * Calculate two week's pay for this employee.
     * 
     * @return the amount this employee is paid every two weeks.
     */
    public abstract double calculatePay();

    /**
     * Return a string representation of this employee.
     * 
     * @return a string of the form "name: id"; for example,
     *         "Cathy Coder: 123456"
     */
    public String toString()
    {
    	return this.name + ": " + this.id;
    }
    
    
    /**
     * Overrides the equals method to compare two
     * objects together
     * 
     * @returns boolean
     */
    
    public boolean equals(Object obj)
    {    	
    	if (obj == null) { return false; }
    	
    	Employee compare_obj = (Employee)obj;
    	
    	if (this.id == compare_obj.id) { return true; }

    	return false;
    }
}
