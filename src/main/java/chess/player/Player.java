package chess.player;

import chess.board.Board;
import chess.piece.Piece;
import chess.piece.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by martijn on 28-1-16.
 */
public class Player {

    /** boolean true if player is white, otherwise false */
    private boolean isWhite;
    /** the name of the player */
    private String name;
    /**
     * pieces the player has. Key is the type of the piece. Value is how many on the board left
     * @see chess.piece.Piece
     */
    private Map<Type, Integer> pieces;
    /** {@link chess.board.Board} object */
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
        pieces = new HashMap<Type, Integer>();
        initializePieces();
    }

    /**
     * Initializes the player.
     *
     * @param isWhite boolean true if player is white, otherwise false
     * @param name name of the player
     */
    public Player(boolean isWhite, String name) {
        this.isWhite = isWhite;
        this.name = name;
    }

    /**
     * Initializes the player board pieces.
     * Firstly the board is created, which places the pieces on the board.
     * After that they are added here
     */
    private void initializePieces() {
        int y = isWhite ? 7 : 1; // row 7 & 8 are white, 1 & 2 are black
        for (int j = 0; j < 2; j++) {
            for (int x = 1; x < Board.DIM + 1; x++) {
                Type boardType = board.getPiece(x, y).getType();
                if(pieces.keySet().contains(boardType)){
                    int value = pieces.get(boardType);
                    pieces.put(boardType, value + 1);
                } else {
                    pieces.put(boardType, 1);
                }
            }
            y++;
        }
    }

    /**
     * Method called to make a move
     *
     * @param fromX x-coordinate from which position you want to move.
     * @param fromY y-coordinate from which position you want to move.
     * @param toX x-coordinate to which position you want to move.
     * @param toY y-coordinate to which position you want to move.
     * @return true if move is made, otherwise false
     */
    public boolean makeMove(int fromX, int fromY, int toX, int toY){
        return board.makeMove(toX, toY, board.getPiece(fromX, fromY));
    }

    /**
     * removes pieces from board pieces
     *
     * @param piece piece to remove
     */
    public void removePiece(Piece piece) {
        int value = pieces.get(piece.getType());
        pieces.put(piece.getType(), value - 1);
    }

    /**
     * returns if the player is white.
     *
     * @return true if the player is white, otherwise false
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Sets the color of the player.
     * used by {@link chess.board.Board#addPlayer(Player)}
     */
    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }
}
