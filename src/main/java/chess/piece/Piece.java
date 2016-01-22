package chess.piece;

import chess.board.Board;
import chess.exception.InvalidStartPosition;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Piece implements IPiece {

    private final Type type;
    private final Color color;

    /**
     * Initialized a piece object, setting its {@link chess.piece.Type} and {@link chess.piece.Color}
     *
     * @param color {@link chess.piece.Color} object of the piece
     * @param type  {@link chess.piece.Type} object of the piece
     */
    public Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public String getName() {
        return color.getName() + type.getName();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Returns the {@link chess.piece.Piece} that belongs on the starting position of (x, y),
     * where {@code 1 < x < 8} and {@code 1 < y < 8}
     *
     * @param x an integer of the x coordinate on the board
     * @param y an integer of the Y coordinate on the board
     * @return {@link chess.piece.Piece} object that belong on (x, y)
     * @throws InvalidStartPosition if {@code x > 8 || y > 8}
     */
    public static Piece getPieceByStartingPosition(int x, int y) throws InvalidStartPosition {
        if (x > 8 || y > 8)
            throw new InvalidStartPosition(x, y);
        if (y == 2)
            return new PiecePawn(Color.BLACK);
        else if (y == 7)
            return new PiecePawn(Color.BLACK);
        else if (y == 1 || y == 8) {
            Color color = y == 1 ? Color.BLACK : Color.WHITE;
            switch (x) {
                case 1:
                case 8:
                    return new PieceRook(color);
                case 2:
                case 7:
                    return new PieceHorse(color);
                case 3:
                case 6:
                    return new PieceBishop(color);
                case 4:
                    return new PieceQueen(color);
                case 5:
                    return new PieceKing(color);
            }
        }
        return Board.NONE_PIECE;
    }
}
