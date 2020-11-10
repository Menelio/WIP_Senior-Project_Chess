package sp.AI;

import java.util.ArrayList;
import java.util.List;

import sp.pieces.Piece;
import sp.pieces.Piece.PieceType;
import sp.application.Square;
import sp.pieces.Team;

public class SubordinateAI extends AI {
	private Team teamColor; 
	private PieceType pieceType;
	private String id;
	
	//TODO update comments
	/**<h1> Default argument Constructor</h1>
	 * <p> Creates instance of SubordinateAI with given values
	 * <p>
	 * @param teamColor Color of team this AI belongs to
	 * @param pieceType Piece type associated with this AI
	 * @author Menelio Alvarez
	 */
	public SubordinateAI(Team teamColor, PieceType pieceType, int row, int col) {
		super();
		this.teamColor = teamColor;
		this.pieceType = pieceType;
		this.row= row;
		this.column = col;
		this.id = ""+row+""+col;
	}




	@Override
	public List<Move> genMoves(Square[][] boardArray) {
		int row = this.row;
		int col = this.column;
		List<Move> moves = new ArrayList<Move>();
		
		//create move parameters
		 int startRow;
		 int startColumn; 
		 int endRow; 
		 int endColumn; 
		 boolean attacking;
		 PieceType targetPiece;
		 int valueOfMove;
		 Move nextMove;
		 
		switch(pieceType) {
			case PAWN:
				
				//position offsets
				int rowOffset[] = {1, 1, 1}; 
				int colOffset[] = {-1, 0, 1};
				
				//gen possible moves
				for(int i=0; i < 3;i++) {
				
					
					if(//check is square is on the board
					   (row+rowOffset[i] > 0 && row+rowOffset[i]< 8) && (col+colOffset[i] >= 0 && col+colOffset[i]<8) 
					) {
						if(boardArray[row+rowOffset[i]][col+colOffset[i]].getPiece()==null ) {
							//TODO need to check/re-implement attack logic
							//create move parameters
							startRow = row;
							startColumn = col;
							endRow = row+rowOffset[i] ;
							endColumn = col+colOffset[i];
							attacking= false;
							targetPiece = null;
							
							valueOfMove = sp.Utils.General.calcMoveValue(row, col, row+rowOffset[i], col+colOffset[i], boardArray);
	
							nextMove = null;//TODO This is supose to be the root node in the tree of moves for this piece so no move is assigned along with it but I'm not sure how to start tree.
							
							 
							moves.add(new Move(startRow, startColumn, endRow, endColumn,attacking, targetPiece,valueOfMove,nextMove,this.id));
						}else if(boardArray[row+rowOffset[i]][col+colOffset[i]].getPiece().getTeam() != this.teamColor){
							//TODO need to check/re-implement attack logic
							//create move parameters
							startRow = row;
							startColumn = col;
							endRow = row+rowOffset[i] ;
							endColumn = col+colOffset[i];
							attacking= true;
							targetPiece = boardArray[row+rowOffset[i]][col+colOffset[i]].getPiece().getPieceType();
								 
							
							valueOfMove = sp.Utils.General.calcMoveValue(row, col, row+rowOffset[i], col+colOffset[i], boardArray);
	
							nextMove = null;//TODO This is supose to be the root node in the tree of moves for this piece so no move is assigned along with it but I'm not sure how to start tree.
							
							 
							moves.add(new Move(startRow, startColumn, endRow, endColumn,attacking, targetPiece,valueOfMove,nextMove,this.id));
						}
					}
				}
			break;
			case ROOK:

			break;
			case KNIGHT:

			break;
			case QUEEN:

			break;
			
		}
		

		return moves;
	}


	//TODO create comments
	public String getId() {
		return id;
	}
	
	
}
