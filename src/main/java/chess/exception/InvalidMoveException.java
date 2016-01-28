package chess.exception;

import chess.lib.ErrorLib;

/**
 * Created by martijn on 27-1-16.
 */
public class InvalidMoveException extends Exception {

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
     * @see ErrorLib
     * @param toX x-coordinate move was attempted to go to
     * @param toY y-coordinate move was attempted to go to
     * @param message One of the messages in {@link ErrorLib}
     */
    public InvalidMoveException(int toX, int toY, String message) {
        this.toX = toX;
        this.toY = toY;
        this.message = message;
        print();
    }

    /**
     * Prints error message
     */
    private void print() {
        if(message.equals(ErrorLib.SAME_LOCATION)){
            System.err.println(message);
        } else {
            System.err.printf(message, toX, toY);
        }
    }
}
