package chess.board;

import chess.exception.InvalidMoveException;
import chess.exception.InvalidStartPositionException;
import chess.exception.OutOfBoardException;
import chess.lib.ErrorLib;
import chess.piece.Piece;
import chess.piece.Type;
import chess.player.Player;
import chess.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static chess.piece.PieceLib.*;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Board {

    /** Dimension of the chess board */
    public static final int DIM = 8;
    /**
     * Map that stores the board. Key is index (starts at 9, ends at 73).
     * Start is defined by (1 * {@link chess.board.Board#DIM} + 1)
     * Value is the {@link chess.board.Spot}
     */
    private Map<Integer, Spot> spots;
    /** Map of the players. The key is true for the white player, false for the black player. */
    private Map<Boolean, Player> players;
    /** Ansi value for red */
    public static final String ANSI_RED = "\u001B[31m";
    /** Ansi value for reset */
    public static final String ANSI_RESET = "\u001B[0m";


    /**
     * Constructor for the {@link chess.board.Board}. Makes the fields, and calls
     * {@link Board#fillBoard()} and {@link Board#printBoard()}
     *
     * @see Board#fillBoard()
     * @see Board#printBoard()
     */
    public Board() {
        spots = new HashMap<Integer, Spot>();
        players = new HashMap<Boolean, Player>();
        fillBoard();
        printBoard();
    }

    /**
     * Fills the board with {@link chess.piece.Piece}s, according to the official starting rules
     */
    private void fillBoard() {
        for (int x = 1; x < DIM + 1; x++) {
            for (int y = 1; y < DIM + 1; y++) {
                try {
                    addField(x, y, Piece.getPieceByStartingPosition(x, y));
                } catch (InvalidStartPositionException invalidStartPosition) {
                    invalidStartPosition.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates a field on the {@link chess.board.Board}
     *
     * @param x x-coordinate to create field
     * @param y y-coordinate to create field
     * @param piece {@link chess.piece.Piece} to add on the field.
     */
    private void addField(int x, int y, Piece piece) {
        if (getSpot(x, y) == null) {
            Spot spot = new Spot();
            spot.setPiece(piece);
            spots.put(Utils.index(x, y), spot);
        }
    }

    /**
     * Sets the field on the board to a specific {@link chess.piece.Piece}
     * Sets the previous location of the {@link chess.piece.Piece} to null
     * If the piece is {@link chess.piece.PiecePawn}, calls {@link chess.board.Board#promptAndSetNewPiece(int, int, boolean)}
     * to request what piece you want.
     * Calls {@link chess.piece.Piece#setX(int)} and {@link chess.piece.Piece#setY(int)}
     *
     * @param x     x-coordinate to place a {@link chess.piece.Piece}
     * @param y     y-coordinate to place a {@link chess.piece.Piece}
     * @param piece desired {@link chess.piece.Piece} to place
     */
    private void setField(int x, int y, Piece piece) {
        Piece toPiece = getPiece(x, y);
        if(toPiece != null) {
            players.get(toPiece.getIsWhite()).removePiece(piece);
        }
        getSpot(piece.getX(), piece.getY()).setEmptyPiece();
        if((y == 1 && piece.getIsWhite() || y == 8 && !piece.getIsWhite()) && piece.getType().equalsType(Type.PAWN)){
            promptAndSetNewPiece(x, y, piece.getIsWhite());
        }
        else {
            getSpot(x, y).setPiece(piece);
            piece.setX(x);
            piece.setY(y);
        }
        printBoard();
    }

    /**
     * Prompts user what piece he wants for his pawn
     *
     * @param x x-coordinate to place replacer pawn
     * @param y y-coordinate to place replacer pawn
     * @param isWhite boolean if the pawn was white
     */
    private void promptAndSetNewPiece(int x, int y, boolean isWhite) {
        boolean answered = false;
        Type type;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter What you want");
        while (!answered) {
            if (sc.hasNext()) {
                switch (sc.next().toLowerCase()) {
                    case NAME_HORSE:
                        type = Type.HORSE;
                        break;
                    case NAME_ROOK:
                        type = Type.ROOK;
                        break;
                    case NAME_BISHOP:
                        type = Type.BISHOP;
                        break;
                    default:
                        type = Type.NONE;
                }
                setField(x, y, new Piece(isWhite, type, x, y));
                answered = true;
            }
        }
    }

    /**
     * Prints the board to the {@link System#out}
     */
    public void printBoard() {
        System.out.printf("   ");
        for (int i = 1; i < DIM + 1; i++) {
            System.out.printf("%d   ", i);
        }
        System.out.println();
        for (int y = 1; y < DIM + 1; y++) {
            System.out.printf("%d  ", y);
            for (int x = 1; x < DIM + 1; x++) {
                if(getPiece(x, y) == null) {
                    System.out.printf("--  ");
                }else {
                    boolean isWhite = getPiece(x, y).getIsWhite();
                    System.out.printf("%s%s%s  " + ANSI_RESET, isWhite ? "" : ANSI_RED, isWhite ? CHAR_WHITE : CHAR_BLACK,
                            getPiece(x, y).getType().toString());
                }
            }
            System.out.printf("\n");
        }
    }

    /**
     * Returns a {@link chess.piece.Piece} on a specific (x, y) coordinate
     *
     * @param x x-coordinate to request {@link chess.piece.Piece}
     * @param y y-coordinate to request {@link chess.piece.Piece}
     * @return {@link chess.piece.Piece} at (x, y)
     */
    public Piece getPiece(int x, int y) {
        return getSpot(x, y).getPiece();
    }

    /**
     * Returns the {@link chess.board.Spot} at specific location
     *
     * @param x x-coordinate of {@link chess.board.Spot}
     * @param y y-coordinate of {@link chess.board.Spot}
     * @return {@link chess.board.Spot} object at coordinates
     */
    private Spot getSpot(int x, int y) {
        return spots.get(Utils.index(x, y));
    }

    /**
     * Returns if a field is empty.
     * Does this by checking if the {@link chess.piece.Type} is equals to {@link chess.piece.Type#NONE}
     *
     * @param x x-coordinate you want to know whether is empty or not
     * @param y y-coordinate you want to know whether is empty or not
     * @return True if both {@link chess.piece.Type}s are equal, otherwise False.
     */
    public boolean isFieldEmpty(int x, int y){
        return getSpot(x, y).isEmpty();
    }

    /**
     * Makes a move.
     * Calls {@link chess.piece.IPiece#validMove(Board, int, int)} to see if move is valid
     *
     * @param fromX x-coordinate you want to move from
     * @param fromY y-coordinate you want to move from
     * @param toX x-coordinate you want to move to
     * @param toY y-coordinate you want to move to
     * @param piece piece you want to move
     * @return true if move is done, otherwise false
     */
    public boolean makeMove(int fromX, int fromY, int toX, int toY, Piece piece) {
        boolean ans = false;
        if(!(players.size() == 0))
            if (getPiece(fromX, fromY) == null)
                new InvalidMoveException(fromX, fromY, toX, toY, ErrorLib.NO_PIECE).print();
        else try {
            boolean a = piece.validMove(this, toX, toY);
            if (a) {
                setField(toX, toY, piece);
                ans = true;
            }
        } catch (InvalidMoveException | OutOfBoardException e) {
            e.print();
            ans = false;
        }
        return ans;
    }

    /**
     * Adds a player to the game. Only 2 players can connect to one game.
     * If the player is white, but a white player is connected already, the player is set to black/
     * calls {@link chess.player.Player#setBoard(Board)}
     *
     * @param player {@link chess.player.Player} object ot add to the game
     */
    public void addPlayer(Player player){
        if(players.size() < 2) {
            if(players.containsKey(player.isWhite())) {
                player.setIsWhite(false);
            }
            players.put(player.isWhite(), player);
            player.setBoard(this);
        }
    }
}
