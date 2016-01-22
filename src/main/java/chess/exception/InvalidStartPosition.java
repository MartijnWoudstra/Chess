package chess.exception;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class InvalidStartPosition extends Exception {

    private int x;
    private int y;

    public InvalidStartPosition(int x, int y) {
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
