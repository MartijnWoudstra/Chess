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

    /** character representation of the type */
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

    /**
     * Returns if the object equals a different object.
     * This means if this object has the same {@link chess.piece.Type} as a different object.
     *
     * @param type {@link chess.piece.Type} you want to check equality
     * @return True if the objects have the same {@link chess.piece.Type}, otherwise false
     */
    public boolean equalsType(Type type){
        return this.toString().equals(type.toString());
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
