/**
 * Pens Project, Version 1 *
 * A Pen is a tool for drawing straight lines in a canvas. Pens are constrained
 * to move in four directions: North, South, East, and West.
 * This class is loosely based on the Smalltalk Pen class and various 
 * Turtle Graphics packages that are available for different languages.
 * 
 * @author  D.L. Bailey
 *          Department of Systems and Computer Engineering,
 *          Carleton University
 * @version 1.05, March 19, 2009.
 */

public class Pen 
{
	/**
	 * Pens Project, Version 1
	 *
	 * A Pen is a tool for drawing straight lines in a canvas. Pens are constrained
	 * to move in four directions: North, South, East, and West.
	 * This class is loosely based on the Smalltalk Pen class and various 
	 * Turtle Graphics packages that are available for different languages.
	 * 
	 * @author  D.L. Bailey
	 *          Department of Systems and Computer Engineering,
	 *          Carleton University
	 * @version 1.05, March 19, 2009.
	 */

	/* Change log.
	 *  1.04 dlb October 25, 2007 dlb  Minor updates for SYSC 1100.
	 *  1.05 dlb March 19, 2009   dlb  moveBy() always makes the DrawingCanvas
	 *                                 visible before drawing a line. This solves
	 *                                 a problem with the previous version of Pen;
	 *                                 namely, if the user closes the canvas window,
	 *                                 invoking a method on a Pen or creating a new
	 *                                 Pen does not cause the canvas to reappear.                            
	 */
	
	 /** Position of the pen along the x-axis. */
	 private int xPosition;
	    
	 /** Position of the pen along the y-axis. */
	 private int yPosition;
	    
	 /** The direction in which the pen will move. */
	 private int direction;
	    
	 /* See turnClockwise() and turnCounterClockwise() before changing the 
	  * values of the following constants.
	  */
	 public static final int NORTH = 0;
	 public static final int EAST = 1;
	 public static final int SOUTH = 2;
	 public static final int WEST = 3;
	 
	 private static final int NUM_SIDE_SQUARE = 4;
	    
	 /** 
	  * True means that the pen is "down" on the canvas and will draw when it 
	  * is moved. 
	  */ 
	 
	 private boolean down;    
	    
	 /** The pen's colour. */
	 private String colour;
	      
	 /**
	  * Constructs a new blue Pen in the down position, placed in the middle of
	  * the canvas, and pointing East (i.e., by default, it will move 
	  * horizontally towards the right of the canvas). 
	  */
	 public Pen()
	 {
	    this.direction = EAST;
	    this.down = true;
	    this.colour = "blue";

	    // Place the pen in the middle of the canvas
	    this.xPosition = DrawingCanvas.canvas.getWidth() / 2;
	    this.yPosition = DrawingCanvas.canvas.getHeight() / 2;       
	 }

	 /**
	  * Places the pen down on the canvas. If the pen was already down, 
	  * invoking this method does not change the pen's state.
	  */
	 public void down()
	 {
	    this.down = true;
	 }
	  
	 /** 
	  * Determines if the pen is in the down position.
	  * 
	  * @return true if the pen is down on the canvas, false otherwise.
	  */
	 public boolean isDown()
	 {
	    return this.down == true;
	 }
	   
	 /**
	  * Picks the pen up from the canvas. If the pen was already up, 
	  * invoking this method does not change the state of the pen.
	  */
	 public void up()
	 {
	    this.down = false;
	 }
	    
	    /** 
	     * Determines if the pen is in the up position.
	     * 
	     * @return true if the pen is not on the canvas, false otherwise.
	     */
	 public boolean isUp()
	 {
	    return !this.down;
	 }  
	    
	 /** 
	  * Turns the pen clockwise by 90 degrees: N -> E -> S -> W -> N.
	  */
	 public void turnClockwise()
	 {
	    this.direction = (this.direction + 1) % 4;
	 }
	    
	 /** 
	  * Turns the pen counterclockwise by 90 degrees: N -> W -> S -> E -> N.
	  */
	 public void turnCounterClockwise()
	 {
	    if (this.direction == NORTH)
	         this.direction = WEST;
	    else
	         this.direction--;
	 } 
	 
	 /**
	  * Returns the pen's current direction.
	  * 
	  * @return the direction in which the pen will move.
	  */
	 public int direction()
	 {
	    return this.direction;
	 }
	    
	 /**
	  * Changes this pen's colour to the specified colour.
	  * 
	  * @param newColour The pen's new colour. Valid colors are "red", "black", 
	  *                  "blue", "yellow", "green", "magenta" and "white".
	  *                  If an invalid colour is specified, the pen's
	  *                  colour doesn't change.
	  * 
	  */
	 public void changeColour(String newColour)
	 {
	     if (newColour.equals("red") ||
	         newColour.equals("black") ||
	         newColour.equals("blue") ||            
	         newColour.equals("yellow") ||
	         newColour.equals("green") ||
	         newColour.equals("magenta") ||
	         newColour.equals("white")) 
	     {              
	         this.colour = newColour;
	     }
	  } 
	    
	    /**
	     * Returns this pen's colour.
	     * 
	     * @return The colour of the lines that the pen draws.
	     */
	    public String colour()
	    {
	        return this.colour;
	    }
	    
	    /** 
	     * Places the pen at the specified coordinates. No line is drawn,
	     * regardless of whether the pen is up or down.
	     * 
	     * @param newX the x coordinate of the pen's new location.
	     * @param newY the y coordinate of the pen's new location. 
	     */ 
	    public void place(int newX, int newY)
	    {
	        this.xPosition = newX;
	        this.yPosition = newY;
	    } 
	 
	    /** 
	     * Returns the x-coordinate of the pen's location on the canvas.
	     * 
	     * @return the x-coordinate of the pen's location.
	     */
	    public int xLocation()
	    {
	        return this.xPosition;
	    }

	    /** 
	     * Returns the y-coordinate of the pen's location on the canvas.
	     * 
	     * @return the y-coordinate of the pen's location.
	     */
	    public int yLocation()
	    {
	        return this.yPosition;
	    }  
	   
	    /** 
	     * Moves the pen by the specified number of pixels in the current direction.
	     * If the pen is down, draws a straight line between the old and new pen 
	     * locations. The pen is not moved if the specified distance is <= 0. 
	     * 
	     * @param distance The distance the pen will be moved from its
	     *                 current location.
	     */
	    public void moveBy(int distance)
	    {
	        if (distance <= 0)
	            return;
	        
	        int newX;
	        int newY;
	        
	        if (this.direction == NORTH) {
	            newY = this.yPosition - distance;
	            newX = this.xPosition;
	        } else if (this.direction == EAST) {
	            newX = this.xPosition + distance;
	            newY = this.yPosition;
	        } else if (this.direction == SOUTH) {
	            newY = this.yPosition + distance;
	            newX = this.xPosition;
	        } else if (this.direction == WEST) { 
	            newX = this.xPosition - distance;
	            newY = this.yPosition;
	        }  else { 
	            /* 
	             * Pen's direction is invalid, so return without moving the pen.
	             * This should never happen, because we don't have a method that
	             * allows us to set the pen's direction to an arbitrary value.
	             */
	            return;
	        }
	        
	        if (this.down) {
	            DrawingCanvas.canvas.setForegroundColour(this.colour);
	            DrawingCanvas.canvas.setVisible(true);
	            DrawingCanvas.canvas.drawLine(this.xPosition, this.yPosition, newX, newY); 
	        }
	        
	        this.place(newX, newY);
	    } 
	    
	    /**
	     * Moves the pen by 20 pixels in the current direction.
	     * If the pen is down, draws a straight line between the old and new pen
	     * locations.
	     */
	    public void move()
	    {
	        this.moveBy(20);
	    }
	    
	    // Exercise 2 method
	    public void drawSquare(int size)
	    {
	    	for (int i = 0; i < NUM_SIDE_SQUARE; i++)
	    	{
	    		this.moveBy(size);
		    	this.turnClockwise();
	    	}
	    }
	    
	    // get values
	    public void inspect()
	    {
	    	System.out.printf("\nColour: %s\nx: %d\ny: %d\nDirect: %d", this.colour(), this.xLocation(), this.yLocation(), this.direction() );
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Exercise 1
		/*
		Pen pen1 = new Pen();
		
		pen1.move();
		
		pen1.turnCounterClockwise();
		
		pen1.move();
		
		pen1.turnCounterClockwise();
		
		pen1.moveBy(100);
		
		pen1.place(80, 40);
		
		pen1.changeColour("red");
		
		pen1.move();
		
		//get values
		System.out.printf("\n\nPen 1");
		pen1.inspect();
		*/
		
		Pen pen2 = new Pen();
		
		pen2.place(170, 90);
		
		pen2.changeColour("green");
		
		//System.out.printf("\n\nPen 1");
		//pen1.inspect();
		
		// is not drawn because of the if condition in drawing
		pen2.up();
		
		pen2.move();
		
		
		
		System.out.printf("\n\nPen 2");
		pen2.inspect();
		
		pen2.down();
		
		pen2.move();
		
		
		//Exercise 2
		
		Pen pen1 = new Pen();
		pen1.changeColour("blue");
		
		pen1.drawSquare(100);

		

	}

}
