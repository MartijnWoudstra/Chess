package chess.exception;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class InvalidStartPositionException extends Exception {

    /** the invalid x-coordinate tha that a invalid starting position */
    private int x;
    /** the invalid y-coordinate tha that a invalid starting position */
    private int y;

    /**
     * Constructor for InvalidStartingPosition
     * @param x x-coordinate piece was attempted to place
     * @param y y-coordinate piece was attempted to place
     */
    public InvalidStartPositionException(int x, int y) {
        this.x = x;
        this.y = y;
        print();
    }

    /**
     * Prints the error message
     */
    private void print() {
        System.out.printf(String.format("The location %d, %dis no valid starting position", x, y));
    }
}
