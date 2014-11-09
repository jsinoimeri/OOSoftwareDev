import java.util.ArrayList;

/**
 * SYSC 2004 Fall 2013 Lab 8
 * 
 * Class Company maintains a collection of employees.
 */
public class Company
{   
	
	ArrayList<Employee> employee_list;
    /**
     * Constructor for objects of class Company
     */
    public Company()
    {
    	this.employee_list = new ArrayList<Employee>();
    }
    
    /**
     * Determine if the specified employee is in the list of employees.
     * 
     * @return true if the employee is in the company's list of employees;
     *         otherwise false.
     */
    public boolean lookupEmployee(Employee e)
    {
    	for(Employee emp: this.employee_list)
    	{
    		if (emp.hasSameID(e)) { return true; }
    	}
    	
        return false;
    }    
    
    /**
     * Add the specified employee to the this company's list of
     * employees, but only if the employee is not already in
     * the list.
     * 
     * @return true if the employee was added to the list, otherwise return false. 
     */
    public boolean addEmployee(Employee e)
    {
    	if (!this.lookupEmployee(e)) 
    	{ 
    		this.employee_list.add(e);
    		return true;
    	}
    	
        return false;
    }
    
    /**
     * Calculate the total payroll for a two-week period.
     * 
     * @return the amount paid to all employees every two weeks. 
     */
    public double calculatePayroll()
    {
    	double total_payroll = 0;
    	
    	for(Employee emp: this.employee_list)
    	{
    		total_payroll += emp.calculatePay();
    	}
    	
        return total_payroll;
    }
}