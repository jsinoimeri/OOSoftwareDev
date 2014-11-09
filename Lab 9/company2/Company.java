import java.util.ArrayList;

/**
 * SYSC 2004 Winter 2013 Lab 9
 * 
 * Class Company maintains a collection of employees.
 */
public class Company
{   
	
	ArrayList<IEmployee> employee_list;
	
    /**
     * Constructor for objects of class Company
     */
    public Company()
    {
    	this.employee_list = new ArrayList<IEmployee>();
    }
    
    /**
     * Determine if the specified employee is in the list of employees.
     * 
     * @return true if e is in the company's list of employees;
     *         otherwise false.
     */
    public boolean lookupEmployee(IEmployee e)
    {
    	for (IEmployee i_e: this.employee_list)
    	{
    		if (i_e.equals(e)) { return true; }
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
    public boolean addEmployee(IEmployee e)
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
     * @return the amount paid to all employees every twoo weeks. 
     */
    public double calculatePayroll()
    {
    	double total_payroll = 0;
    	
    	for(IEmployee emp: this.employee_list)
    	{
    		total_payroll += emp.calculatePay();
    	}
    	
        return total_payroll;
    }  
}
