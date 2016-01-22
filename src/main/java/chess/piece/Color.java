package chess.piece;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public enum Color {
    WHITE(PieceLib.CHAR_WHITE), BLACK(PieceLib.CHAR_BLACK), NONE(PieceLib.CHAR_NONE);

    private final char id;

    /**
     * Initializes a color, setting its Character representation.
     *
     * @param id Character representation of the color
     */
    Color(char id) {
        this.id = id;
    }

    /**
     * Returns a {@link chess.piece.Color} corresponding to the given id
     *
     * @param id Character to identify {@link chess.piece.Color} with
     * @return {@link chess.piece.Color}, default returns {@link chess.piece.Color#NONE}
     */
    public static Color getColorFromChar(char id) {
        switch (id) {
            case PieceLib.CHAR_WHITE:
                return WHITE;
            case PieceLib.CHAR_BLACK:
                return BLACK;
            default:
                return NONE;
        }
    }

    /**
     * Returns the name corresponding to this {@link chess.piece.Color}
     *
     * @return String corresponding to this {@link chess.piece.Color}. default returns {@link chess.piece.Color#NONE}
     */
    public String getName() {
        return Color.getNameFromChar(id);
    }

    /**
     * Returns the name corresponding to any {@link chess.piece.Color}
     *
     * @param id character representation of the Color
     * @return      String corresponding to the id. default returns {@link chess.piece.Color#NONE}
     */
    public static String getNameFromChar(char id) {
        switch (id) {
            case PieceLib.CHAR_WHITE:
                return PieceLib.NAME_WHITE;
            case PieceLib.CHAR_BLACK:
                return PieceLib.NAME_BLACK;
            default:
                return PieceLib.NAME_NONE;
        }
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
