/*Contributing team members
 * Richard OlgalTree
 * Menelio Alvarez
*/
package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import pieces.Team;
import player.BlackPlayer;
import player.GoldPlayer;
import player.Player;

public class Board {
	
	private final List<Tile> gameBoard;
	private final Collection<Piece> goldPieces;
	private final Collection<Piece> blackPieces;
	
	private final GoldPlayer goldPlayer;
	private final BlackPlayer blackPlayer;
	
	private Board(Builder builder) {
		this.gameBoard = createGameBoard(builder);
		this.goldPieces = calculateActivePieces(this.gameBoard, Team.GOLD);
		this.blackPieces = calculateActivePieces(this.gameBoard, Team.BLACK);
		
		final Collection<Move> goldStandardLegalMoves = calculateLegalMoves(this.goldPieces);
		final Collection<Move> blackStandardLegalMoves = calculateLegalMoves(this.blackPieces);
		
		this.goldPlayer = new GoldPlayer(this, goldStandardLegalMoves, blackStandardLegalMoves);
		this.blackPlayer = new BlackPlayer(this, goldStandardLegalMoves, blackStandardLegalMoves);
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < GeneralUtils.NUM_TILES; i++) {
			final String tileText = this.gameBoard.get(i).toString();
			builder.append(String.format("%3s", tileText));
			if ((i+1) % 8 == 0) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
	public Player goldPlayer() {
		return this.goldPlayer;
	}
	
	public Player blackPlayer() {
		return this.blackPlayer;
	}
	
	public Collection<Piece> getBlackPieces() {
		return this.blackPieces;
	}
	
	public Collection<Piece> getGoldPieces() {
		return this.goldPieces;
	}
	
	private Collection<Move> calculateLegalMoves(final Collection<Piece> pieces) {
		final List<Move> legalMoves = new ArrayList<>();
		for (final Piece piece : pieces) {
			legalMoves.addAll(piece.calculateLegalMoves(this));
		}
		return legalMoves;
	}

	private static Collection<Piece> calculateActivePieces(final List<Tile> gameBoard, final Team team) {
		final List<Piece> activePieces = new ArrayList<>();
		for (final Tile tile : gameBoard) {
			if (tile.isTileOccupied()) {
				final Piece piece = tile.getPiece();
				if (piece.getPieceTeam() == team) {
					activePieces.add(piece);
				}
			}
		}
		return activePieces;
	}
	
	public Tile getTile(final int tileCoord) {
		return gameBoard.get(tileCoord);
	}
	
	private static List<Tile> createGameBoard(final Builder builder) {
		final Tile[] tiles = new Tile[GeneralUtils.NUM_TILES];
		for (int i = 0; i < GeneralUtils.NUM_TILES; i++) {
			tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
		}
		
		return Arrays.asList(tiles); //List.of(tiles); was returning this but had to change not sure why : change made by Menelio Alvarez 10/4
	}
	
	public static Board createStandardBoard() {
		final Builder builder = new Builder();
		
		// black pieces
		builder.setPiece(new Rook(0, Team.BLACK));
		builder.setPiece(new Knight(1, Team.BLACK));
		builder.setPiece(new Bishop(2, Team.BLACK));
		builder.setPiece(new Queen(3, Team.BLACK));
		builder.setPiece(new King(4, Team.BLACK));
		builder.setPiece(new Bishop(5, Team.BLACK));
		builder.setPiece(new Knight(6, Team.BLACK));
		builder.setPiece(new Rook(7, Team.BLACK));
		builder.setPiece(new Pawn(8, Team.BLACK));
		builder.setPiece(new Pawn(9, Team.BLACK));
		builder.setPiece(new Pawn(10, Team.BLACK));
		builder.setPiece(new Pawn(11, Team.BLACK));
		builder.setPiece(new Pawn(12, Team.BLACK));
		builder.setPiece(new Pawn(13, Team.BLACK));
		builder.setPiece(new Pawn(14, Team.BLACK));
		builder.setPiece(new Pawn(15, Team.BLACK));
		// white pieces
		builder.setPiece(new Pawn(48, Team.GOLD));
		builder.setPiece(new Pawn(49, Team.GOLD));
		builder.setPiece(new Pawn(50, Team.GOLD));
		builder.setPiece(new Pawn(51, Team.GOLD));
		builder.setPiece(new Pawn(52, Team.GOLD));
		builder.setPiece(new Pawn(53, Team.GOLD));
		builder.setPiece(new Pawn(54, Team.GOLD));
		builder.setPiece(new Pawn(55, Team.GOLD));
		builder.setPiece(new Rook(56, Team.GOLD));
		builder.setPiece(new Knight(57, Team.GOLD));
		builder.setPiece(new Bishop(58, Team.GOLD));
		builder.setPiece(new Queen(59, Team.GOLD));
		builder.setPiece(new King(60, Team.GOLD));
		builder.setPiece(new Bishop(61, Team.GOLD));
		builder.setPiece(new Knight(62, Team.GOLD));
		builder.setPiece(new Rook(63, Team.GOLD));
		// set Gold to move first
		builder.setMoveMaker(Team.GOLD);
		return builder.build();
	}
	
	public static class Builder {
		
		Map<Integer, Piece> boardConfig;
		Team nextMoveMaker;
		
		public Builder() {
			this.boardConfig = new HashMap<>();
		}
		
		public Builder setPiece(final Piece piece) {
			this.boardConfig.put(piece.getPiecePosition(), piece);
			return this;
		}
		
		public Builder setMoveMaker(final Team nextMoveMaker) {
			this.nextMoveMaker = nextMoveMaker;
			return this;
		}
		
		public Board build() {
			return new Board(this);
		}
		
	}
	
/////////////////////////////TESTING METHODS/////////////////////////////
	
	/**<h2>Create Test Board</h2>
	 * <p>
	 * Create custom board given an array of pieces and returns it 
	 * (For testing) 
	 * </p>
	 * @param p Array of pieces to be set on test board.
	 * @return Board: an empty Board
	 * @author Menelio Alvarez
	 * */
	public static Board createTestBoard(Piece[] p) {
		final Builder builder = new Builder();
		
		for(int i=0; i < p.length;i++) {
			
			builder.setPiece(p[i]);
		}
		
		builder.setPiece(new King(60, Team.GOLD));
		builder.setPiece(new King(4, Team.BLACK));
		builder.setMoveMaker(Team.GOLD);
		return builder.build();
	}
	

}