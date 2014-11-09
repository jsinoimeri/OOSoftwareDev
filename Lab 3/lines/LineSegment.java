/**
 * A LineSegment object models a line in the two-dimensional Cartesian plane.
 * 
 * @author (your name) 
 * @version Version 1.00 January 18, 2012
 */
public class LineSegment
{
    // Declare fields here.
    private Point fromPoint,
                  toPoint;
    
    /**
     * Initializes this LineSegement with starting point (x1, y1) and
     * ending point (x2, y2).
     */
    public LineSegment(double x1, double y1, double x2, double y2)
    {
        this.fromPoint = new Point(x1, y1);
        this.toPoint = new Point(x2, y2);
    }
    
    /**
     * Returns the starting point of this LineSegment.
     */
    public Point getStartingPoint()
    {
        return this.fromPoint;
    }
    /**
     * Returns the ending point of this LineSegment.
     */
    public Point getEndingPoint()
    {
        return this.toPoint;
    }  
    
    /**
     * Returns the length of this LineSegment.
     */
    public double length()
    {
        // Replace this return statement with your method.        
        return Math.sqrt((this.fromPoint.getX()-this.toPoint.getX()) * (this.fromPoint.getX()-this.toPoint.getX()) + (this.fromPoint.getY()-this.toPoint.getY())*(this.fromPoint.getY()-this.toPoint.getY()));  // Return "Not a Nunber" to keep the compiler happy.
    }
    
    /**
     * Moves this LineSegment the specified distance horizontally.
     */
    public void moveHorizontal(double distance)
    {
        this.fromPoint.shift(distance, 0);
        this.toPoint.shift(distance, 0);
    }

    /**
     * Moves this LineSegment the specified distance vertically.
     */
    public void moveVertical(double distance)
    {
        this.fromPoint.shift(0, distance);
        this.toPoint.shift(0, distance);
    }
    
    /**
     * Returns true if this LineSegment is a vertical line;
     * otherwise returns false.
     */
    public boolean isVertical()
    {
        return Math.abs(this.fromPoint.getX()-this.toPoint.getX()) < 0.0001;
    }
    
     /**
     * Returns true if this LineSegment is a horizontal line;
     * otherwise returns false.
     */
    public boolean isHorizontal()
    {
        return Math.abs(this.fromPoint.getY()-this.toPoint.getY()) < 0.0001;
    }   
    
    /**
     * Returns the slope of this LineSegment. 
     */
    public double slope()
    {
        // Replace this return statement with your method.
        
        /*
        if (this.isVertical())
            //return Double.POSITIVE_INFINITY;  // Return "Not a Nunber" to keep the compiler happy.
        return (this.toPoint.getY()-this.fromPoint.getY()) / (this.toPoint.getX() - this.fromPoint.getX());
        */
       
        return (this.isVertical()) ? Double.POSITIVE_INFINITY : (this.toPoint.getY()-this.fromPoint.getY()) / (this.toPoint.getX() - this.fromPoint.getX());
    }
}
