package chess.exception;

/**
 * Created by martijn on 23-1-16.
 */
public class EmptyFieldException extends Throwable {

    private int x;
    private int y;

    public EmptyFieldException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return String.format("(%d, %d) is an empty field!", x, y);
    }
}
