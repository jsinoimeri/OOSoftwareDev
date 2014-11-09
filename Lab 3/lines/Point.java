/**
 * A Point object models a point represented by two-dimensional Cartesian
 * coordinates; that is, a point whose coordinates are represented by an 
 * ordered pair of real numbers,(x, y).
 * 
 * @author (your name) 
 * @version Version 1.00 January 18, 2012
 */
public class Point
{
    // Declare fields here.
    private double x,
                   y;

    /**
     * Initializes this Point so that lies at the origin, (0, 0).
     */
    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Initializes this Point with the specified x and y coordinates.
     */
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }  
    
    /**
     * Returns this Point's x coordinate.
     */
    public double getX()
    {
        // Replace this return statement with your method.
        return this.x;  // Return "Not a Nunber" to keep the compiler happy.
    }
    
    /**
     * Returns this Point's y coordinate.
     */
    public double getY()
    {
        // Replace this return statement with your method.        
        return this.y;  // Return "Not a Nunber" to keep the compiler happy.
    }

    /**
     * Shift this Point delta_x units along the x-axis and 
     * delta-y units along the y-axis.
     */
    public void shift(double delta_x, double delta_y)
    {
        this.x += delta_x;
        this.y += delta_y;
    }
}   

