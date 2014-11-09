/**
 * SYSC 2004 Fall 2013 Lab 8.
 * 
 * Class Employee is the superclass for classes that 
 * model all types of employees.
 */
public abstract class Employee
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
     * Determines if this employee and employee emp are the same employee, based on their ID.
     * @return true if employee emp has the same ID as this employee; otherwise false.
     */
    public boolean hasSameID(Employee emp)
    {
    	return this.id == emp.id;
    }
    
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
}
