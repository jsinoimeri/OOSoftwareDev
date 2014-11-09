/**
 * Class ChessPiece models pieces in a chess game.
 * 
 * @author D.L. Bailey
 * @version 1.00 March 26, 2007, v 1.01 March 28, 2011, v 1.02 March 7, 2012, 
 *          v. 1.03 Nov. 4, 2013
 */
public abstract class ChessPiece
{
    /* Rows and columns are numbered 1 through 8. */
    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final int MIN_COL = 1;
    public static final int MAX_COL = 8;   
    
    private String name;
    private boolean isWhite;
    private int column;
    private int row;
    
    /** Initializes those fields of a chess piece that are common to all pieces.
     *
     * @param isWhite true if the piece is white, false if the piece is black
     * @param initialRow the row of the square where the piece is initially placed
     * @param initialColumn the column of the square where the piece is initially placed
     */
    public ChessPiece(boolean isWhite, int initialRow, int initialColumn)
    {
        this.name = this.getClass().getName();
        this.isWhite = isWhite;
        this.row = initialRow;
        this.column = initialColumn;
    }
 
    /**
     * Returns true if this piece is white, otherwise returns false.
     */
    public boolean isWhite()
    {
        return this.isWhite;
    }
    
    /**
     * Returns a string representation of this piece; for example,
     * "White Rook, row = 3, column = 7" or
     * "Black Bishop, row = 5, column = 2"
     */
    public String toString()
    {
        String s;
        
        if (isWhite) {
            s = "White ";
        } else {
            s = "Black ";
        }
        s = s + this.name + ", row = " + this.row + ", column = " + this.column;
        return s;
    }

    /**
     * Returns the row of this piece's position.
     */
    public int getRow()
    {
        return this.row;
    }
 
    /**
     * Returns the column of this piece's position.
     */    
    public int getColumn()
    {
        return this.column;
    }
    
    /**
     * Moves this piece to the specified location on the chess board if it can
     * legally do so. Otherwise, the location of this piece is not changed.
     * 
     * @param desiredRow the row where we want to move this piece.
     * @param desiredColumn the column where we want to move this piece. 
     */
    public void moveTo(int desiredRow, int desiredColumn)
    {
    	if (this.canMoveTo(desiredRow, desiredColumn)) 
    	{
    		this.row = desiredRow;
    		this.column = desiredColumn;
    	}
    }
    
    /**
     * Returns true is this piece can legally move to the specified location
     * on the chess board, otherwise returns false.
     * 
     * This method does not move the piece!
     * 
     * @param desiredRow the row where we want to move this piece.
     * @param desiredColumn the column where we want to move this piece.
     */
    
    /*
     * public boolean canMoveTo(int desiredRow, int desiredColumn)
     * {
     * 		if (desiredRow >= MIN_ROW && desiredRow <= MAX_ROW && desiredColumn >= MIN_COL && desiredColumn <= MAX_COL ) 
     * 		{
     * 			return true;
     * 		}
     * 
     * 		return false;
     * }
     */
    
    public abstract boolean canMoveTo(int desiredRow, int desiredColumn);

}
