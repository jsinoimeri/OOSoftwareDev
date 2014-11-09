
/**
 * SYSC 2004 Winter 2013 Lab 9.
 * 
 * Class SalariedEmployee models employees who have an annual salary. 
 */
public class SalariedEmployee extends Employee
{
	private double annual_pay;

	public SalariedEmployee(String name, long id)
	{
		super(name, id);
		this.annual_pay = 0;
	}


	public double calculatePay()
	{
		return this.annual_pay / 26;
	}
	

	/**
	* Set this employee's annual salary to the
	* specified amount.
	* 
	* @param salary
	*/
	public void setAnnualSalary(double salary)
	{
		this.annual_pay = salary;
	}
}
