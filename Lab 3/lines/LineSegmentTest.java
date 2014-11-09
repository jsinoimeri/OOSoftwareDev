/**
 * The test class LineSegmentTest.
 *
 * @author  D.L. Bailey, SCE, Carleton University
 * @version 1.00, January 18, 2012
 */
public class LineSegmentTest extends junit.framework.TestCase
{
	private LineSegment lineSegm1;
	private LineSegment lineSegm2;
	private LineSegment lineSegm3;

    /**
     * Default constructor for test class LineSegmentTest
     */
    public LineSegmentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
		lineSegm1 = new LineSegment(1.0, 2.0, 4.0, 6.0);
		lineSegm2 = new LineSegment(1.5, 2.5, 1.5, 5.5);
		lineSegm3 = new LineSegment(4.2, 3.7, 6.9, 3.7);
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

	public void testConstructor()
	{
	    Point point;
	    
		point = lineSegm1.getStartingPoint();
		assertEquals(1.0, point.getX(), 0.0001);
		assertEquals(2.0, point.getY(), 0.0001);
		
		point = lineSegm1.getEndingPoint();
		assertEquals(4.0, point.getX(), 0.0001);
		assertEquals(6.0, point.getY(), 0.0001);	    
	    
		point = lineSegm2.getStartingPoint();
		assertEquals(1.5, point.getX(), 0.0001);
		assertEquals(2.5, point.getY(), 0.0001);
		
		point = lineSegm2.getEndingPoint();
		assertEquals(1.5, point.getX(), 0.0001);
		assertEquals(5.5, point.getY(), 0.0001);
		
		point = lineSegm3.getStartingPoint();
		assertEquals(4.2, point.getX(), 0.0001);
		assertEquals(3.7, point.getY(), 0.0001);
		
		point = lineSegm3.getEndingPoint();
		assertEquals(6.9, point.getX(), 0.0001);
		assertEquals(3.7, point.getY(), 0.0001);		
	}

	public void testLength()
	{
		assertEquals(5.0, lineSegm1.length(), 0.0001);
		assertEquals(3.0, lineSegm2.length(), 0.0001);
		assertEquals(2.7, lineSegm3.length(), 0.0001);
	}

	public void testMoveHorizontal()
	{
		lineSegm1.moveHorizontal(5.0);
		Point point1 = lineSegm1.getStartingPoint();
		assertEquals(6.0, point1.getX(), 0.0001);
		assertEquals(2.0, point1.getY(), 0.0001);
		Point point2 = lineSegm1.getEndingPoint();
		assertEquals(9.0, point2.getX(), 0.0001);
		assertEquals(6.0, point2.getY(), 0.0001);
	}
	
	public void testMoveVertical()
	{
		lineSegm1.moveVertical(5.0);
		Point point1 = lineSegm1.getStartingPoint();
		assertEquals(1.0, point1.getX(), 0.0001);
		assertEquals(7.0, point1.getY(), 0.0001);
		Point point2 = lineSegm1.getEndingPoint();
		assertEquals(4.0, point2.getX(), 0.0001);
		assertEquals(11.0, point2.getY(), 0.0001);
	}

	public void testIsVertical()
	{
		assertEquals(false, lineSegm1.isVertical());
		assertEquals(true, lineSegm2.isVertical());
		assertEquals(false, lineSegm3.isVertical());
	}
	
	public void testIsHorizontal()
	{
		assertEquals(false, lineSegm1.isHorizontal());
		assertEquals(false, lineSegm2.isHorizontal());
		assertEquals(true, lineSegm3.isHorizontal());
	}	

	public void testSlope()
	{
		assertEquals(1.3333, lineSegm1.slope(), 0.0001);
		assertEquals(Double.POSITIVE_INFINITY, lineSegm2.slope(), 0.0001);
		assertEquals(0.0, lineSegm3.slope(), 0.0001);
	}
}





