package chess.exception;

import chess.lib.ErrorLib;

/**
 * Created by martijn on 27-1-16.
 */
public class InvalidMoveException extends Exception implements ChessException {

    private int fromX;
    private int fromY;
    /** the x-position attempted to move to*/
    private int toX;
    /** the y-position attempted to move to*/
    private int toY;
    /** the message that needs to be printed.
     * @see chess.lib.ErrorLib
     */
    private String message;

    /**
     * Constructor for InvalidMoveException.
     *
     * @see ErrorLib
     * @param fromX x-coordinate move was attempted to move from
     * @param fromY y-coordinate move was attempted to move from
     * @param toX x-coordinate move was attempted to go to
     * @param toY y-coordinate move was attempted to go to
     * @param message One of the messages in {@link ErrorLib}
     */
    public InvalidMoveException(int fromX, int fromY, int toX, int toY, String message) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.message = message;
    }

    public void print() {
        switch (message) {
            case ErrorLib.SAME_LOCATION:
                System.out.println(message);
                break;
            case ErrorLib.NO_PIECE:
                System.out.printf(message, fromX, fromY);
                break;
            default:
                System.out.printf(message, toX, toY);
                break;
        }
    }
}
