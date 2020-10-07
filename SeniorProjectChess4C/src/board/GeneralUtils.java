/*Contributing team members
 * Richard OlgalTree
 * Menelio Alvarez
*/
package board;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Team;

// holds utility methods that will be used by multiple classes
public class GeneralUtils {
	
	public static final boolean[] FIRST_COLUMN = initColumn(0);
	public static final boolean[] EIGHTH_COLUMN = initColumn(7);
	
	public final List<Boolean> FIRST_ROW = initRow(0);
    public final List<Boolean> SECOND_ROW = initRow(8);
    public final List<Boolean> THIRD_ROW = initRow(16);
    public final List<Boolean> FOURTH_ROW = initRow(24);
    public final List<Boolean> FIFTH_ROW = initRow(32);
    public final List<Boolean> SIXTH_ROW = initRow(40);
    public final List<Boolean> SEVENTH_ROW = initRow(48);
    public final List<Boolean> EIGHTH_ROW = initRow(56);
	
	// variable for number of tiles on the chess board
	// used when creating the empty and occupied tiles
	public static final int NUM_TILES = 64;
	public static final int NUM_TILES_PER_ROW = 8;
	
	// no objects will be made of this class so want to prevent instantiation
	protected GeneralUtils() {
		throw new RuntimeException("Cannot be instatiated");
	}
	
	/* method to create a boolean array that is true in every space in the column
	   indicated by "columnNumber". is false in every other element. this helps with
	   getting column exclusions when determining if a candidate move is valid. */
	private static boolean[] initColumn(int columnNumber) {
		// size 64 covers the entire size of the board
		final boolean[] column = new boolean[64];
		// moves to each row and sets the column space to true
		do {
			column[columnNumber] = true;
			columnNumber += 8;
		} while (columnNumber < 64);
		return column;
	}
	
	private static List<Boolean> initRow(int rowNumber) {
        final Boolean[] row = new Boolean[NUM_TILES];
        for(int i = 0; i < row.length; i++) {
            row[i] = false;
        }
        do {
            row[rowNumber] = true;
            rowNumber++;
        } while(rowNumber % NUM_TILES_PER_ROW != 0);
        return Collections.unmodifiableList(Arrays.asList(row));
    }
	
	// looks to see if a possible move destination is within the bounds of the chess board
	public static boolean isValidTileCoordinate(final int coordinate) {
		return coordinate >= 0 && coordinate < 64;
	}
	
	/**<h2>Get 2d char array Board</h2>
	 * <p>
	 * Creates a 2d array of chars given a Board object, that is populated with
	 * chars representing the current position of pieces on the board. 
	 * Upper Case chars are GOLD lower case are black 
	 * </p>
	 * @param board The board object to build char[][] 
	 * @return char[][] of board.
	 * @author Menelio Alvarez
	 * */
	public static char[][] get2dCharBoard(Board board){
		//char array to return
		char[][] charBoard = new char[8][8];
		//index of tile on given board object to iterate through board
		int indx=0;
		//loop to populate array
		for(int i=0; i < charBoard.length;i++) {
			for(int j=0; j < charBoard[0].length; j++) {
				if(board.getTile(indx).isTileOccupied()) {
					if(board.getTile(indx).getPiece().getPieceTeam() == Team.GOLD) {
						switch(board.getTile(indx).getPiece().getPieceType()) {
						case PAWN:
							charBoard[i][j]= 'P';
							break;
						case KNIGHT:
							charBoard[i][j]= 'N';
							break;
						case BISHOP:
							charBoard[i][j]= 'B';
							break;
						case ROOK:
							charBoard[i][j]= 'R';
							break;
						case QUEEN:
							charBoard[i][j]= 'Q';
							break;
						case KING:
							charBoard[i][j]= 'K';
							break;
						}
						
					}else {
						switch(board.getTile(indx).getPiece().getPieceType()) {
						case PAWN:
							charBoard[i][j]= 'p';
							break;
						case KNIGHT:
							charBoard[i][j]= 'n';
							break;
						case BISHOP:
							charBoard[i][j]= 'b';
							break;
						case ROOK:
							charBoard[i][j]= 'r';
							break;
						case QUEEN:
							charBoard[i][j]= 'q';
							break;
						case KING:
							charBoard[i][j]= 'k';
							break;
						}
					}
				}else {
					charBoard[i][j]='-';
				}
				indx++;	
			}
		}
		
		return charBoard;
	}

	/**<h2>Convert 1d index to 2d index</h2>
	 * <p>
	 * Given the 1 dimensional position/index of a piece in the 1 dimensional 
	 * board array this method returns the corresponding position/indexes for
	 * a 2 dimensional array in an integer array of size 2 (x is at 0, y is at 1). 
	 * </p>
	 * @param pos The 1 dimensional integer index/position 
	 * @return int[] containing the 2 dimensional indexes/positions
	 * (x is at 0, y is at 1).
	 * @author Menelio Alvarez
	 * */
	public static int[] convertPosTo2D(int pos) {
		int[] pos2d={(pos % 8), (pos / 8)};
		
		return pos2d;
	}
	
	/**<h2>Convert 2d index to 1d index</h2>
	 * <p>
	 * Given the 2 coordinate of a piece in the 2 dimensional 
	 * board array this method returns the corresponding position/indexes
	 * in a 1 dimensional array board. 
	 * </p>
	 * @precondition x and y must be positive, if not method returns -1
	 * @param x The x coordinate of the piece 
	 * @param y The y coordinate of the piece 
	 * @return Integer index/position of piece in a 1 dimensional array.
	 * @author Menelio Alvarez
	 * 
	 * */
	public static int convertPosTo1D(int x, int y) {
		if(x >=0 && y >= 0) {
			return ((y*8)+x);
		}else {
			return -1;
		}
	}
}