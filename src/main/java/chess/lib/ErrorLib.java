package chess.lib;

/**
 * Created by martijn on 27-1-16.
 */

/**
 * Library with error messages
 */
public class ErrorLib {
    public static final String SAME_LOCATION = "You cannot move a piece to the same location!";
    public static final String OUTSIDE_FIELD = "You cannot place a tile at %d %d!";
    public static final String SAME_COLOR = "You cannot place a piece at %d %d. That field has the same color!";
    public static final String HIT_KING = "You cannot hit the king!";
}
