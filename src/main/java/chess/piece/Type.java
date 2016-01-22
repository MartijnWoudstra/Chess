package chess.piece;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public enum Type {
    PAWN(PieceLib.CHAR_PAWN), HORSE(PieceLib.CHAR_HORSE), BISHOP(PieceLib.CHAR_BISHOP),
    ROOK(PieceLib.CHAR_ROOK), QUEEN(PieceLib.CHAR_QUEEN), KING(PieceLib.CHAR_KING), NONE(PieceLib.CHAR_NONE);

    private final char id;

    /**
     * Initializes a type, setting its Character representation.
     *
     * @param id Character representation of the type
     */
    Type(char id) {
        this.id = id;
    }

    /**
     * Returns a {@link chess.piece.Type} corresponding to the given id
     *
     * @param id Character to identify {@link chess.piece.Type} with
     * @return {@link chess.piece.Type}, default returns {@link chess.piece.Type#NONE}
     */
    public static Type getTypeFromChar(char id) {
        switch (id) {
            case PieceLib.CHAR_PAWN:
                return PAWN;
            case PieceLib.CHAR_HORSE:
                return HORSE;
            case PieceLib.CHAR_BISHOP:
                return BISHOP;
            case PieceLib.CHAR_ROOK:
                return ROOK;
            case PieceLib.CHAR_QUEEN:
                return QUEEN;
            case PieceLib.CHAR_KING:
                return KING;
            default:
                return NONE;
        }
    }

    /**
     * Returns the name corresponding to this {@link chess.piece.Type}
     *
     * @return String corresponding to this {@link chess.piece.Type}. default returns {@link chess.piece.Type#NONE}
     */
    public String getName() {
        return Type.getNameFromChar(id);
    }

    /**
     * Returns the name corresponding to any {@link chess.piece.Type}
     *
     * @param id Character representation of the type
     * @return String corresponding to the id. default returns {@link chess.piece.Type#NONE}
     */
    public static String getNameFromChar(char id) {
        switch (id) {
            case PieceLib.CHAR_PAWN:
                return PieceLib.NAME_PAWN;
            case PieceLib.CHAR_HORSE:
                return PieceLib.NAME_HORSE;
            case PieceLib.CHAR_BISHOP:
                return PieceLib.NAME_BISHOP;
            case PieceLib.CHAR_ROOK:
                return PieceLib.NAME_ROOK;
            case PieceLib.CHAR_QUEEN:
                return PieceLib.NAME_QUEEN;
            case PieceLib.CHAR_KING:
                return PieceLib.NAME_KING;
            default:
                return PieceLib.NAME_NONE;
        }
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
