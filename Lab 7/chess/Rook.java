/**
 * Rook models the rook piece in a chess game.
 * 
 * @author D.L. Bailey
 * @version 1.00 March 26, 2007, v 1.01 March 28, 2011, v 1.02 March 7, 2012
 * 
 */
public class Rook extends ChessPiece
{
    /** 
     * Constructs a Rook with the specified colour and initial position.
     * 
     * @param isWhite true if the piece is white, false if the piece is black
     * @param initialRow the row of the square where the piece is initially placed
     * @param initialColumn the column of the square where the piece is initially placed
     */
    public Rook(boolean isWhite, int initialRow, int initialColumn)
    {
    	super(isWhite, initialRow, initialColumn);
    }
    
    /**
     * Returns true is this piece can legally move to the specified location
     * on the chess board.
     * Returns false if the specified row or column is not on a chess board,
     * or if moving to the specified location is not a legal move for a rook.
     * 
     * This method does not move the piece!
     * 
     * @param desiredRow the row where we want to move this piece.
     * @param desiredColumn the column where we want to move this piece.
     */
    public boolean canMoveTo(int desiredRow, int desiredColumn)
    {   
    	// if ( (this.getRow() - desiredRow) == (this.getColumn() - desiredColumn) && super.canMoveTo(desiredRow, desiredColumn) )
    	
    	if ( (this.getRow() == desiredRow || this.getColumn() == desiredColumn) 
    			&& (desiredRow >= MIN_ROW && desiredRow <= MAX_ROW) 
    			&& (desiredColumn >= MIN_COL && desiredColumn <= MAX_COL) ) 
    	{ 
    		return true; 
    	}
    	
        return false;
    }
}
