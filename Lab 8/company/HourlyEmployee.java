/**
 * SYSC 2004 Fall 2013 Lab 8.
 * 
 * Class HourlyEmployee models employees who work a number of hours
 * per week for an hourly wage. 
 */
public class HourlyEmployee extends Employee
{
	private double hours_worked,
				   wage_per_hour;

	public HourlyEmployee(String name, long id)
	{
		super(name, id);
		this.wage_per_hour = this.hours_worked = 0;
	}


	public double calculatePay()
	{
		return (this.wage_per_hour * this.hours_worked) * 2;
	}
	
	
	/**
	* Sets this employee's hourly wage to the specified wage.
	*
	* @param wage the amount this employee earns in one hour.
	*/
	public void setHourlyWage(double wage)
	{
		this.wage_per_hour = wage;
	}
	
	
	
	/**
	* Sets the number of hours this employee works in
	* one week.
	*
	* @param hours the hours this employee works each week.
	*/
	public void setHoursWorked(double hours)
	{
		this.hours_worked = hours;
	}
}