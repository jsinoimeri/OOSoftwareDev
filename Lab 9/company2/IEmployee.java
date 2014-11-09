/**
 * SYSC 2004 Winter 2013 Lab 9.
 * 
 * IEmployee specifies the methods provided by all classes
 * the model employees.
 */
public interface IEmployee
{   
    /**
     * Calculate two week's pay for this employee.
     * 
     * @return the amount this employee is paid every two weeks.
     */
    public double calculatePay();
    
    /**
     * Determines if this employee is identical to obj.
     * @return true if obj is an employee that is identical to
     *              this employee; otherwise false.
     */
    public boolean equals(Object obj);
    
    /**
     * Return a string representation of this employee.
     * 
     * @return a string of the form "name: id"; for example,
     *         "Cathy Coder: 123456"
     */
    public String toString();
}
