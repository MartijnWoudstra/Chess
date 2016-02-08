package chess.lib;

/**
 * ${PROJECT_NAME}
 * @author      Martijn Woudstra
 * @version     1.0
 * @since       27-1-16
 */
/**
 * Library with error messages
 */
public class ErrorLib {
    public static final String SAME_LOCATION = "You cannot move a piece to the same location!\n";
    public static final String SAME_COLOR = "You cannot place a piece at %d %d. That field has the same color!\n";
    public static final String HIT_KING = "You cannot hit the king!\n";
    public static final String NO_PIECE = "There is not piece at (%d, %d)!\n";
    public static final String INVALID_INPUT = "give a valid input!";
}
