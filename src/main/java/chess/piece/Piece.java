package chess.piece;

import chess.board.Board;
import chess.exception.InvalidStartPosition;
import chess.util.Utils;

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
    protected int[] normalMoves;
    private int[] hitMoves;

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

    @Override
    public boolean validMove(int x, int y, int dx, int dy, Board board) {
        return validNormalMove(x, y, dx, dy, board);
    }

    private boolean validNormalMove(int x, int y, int dx, int dy, Board board) {
        boolean ans = false;
        if (!board.isFieldEmpty(x, y)) {
            int modifier = color.equalsColor(Color.WHITE) ? -1 : 1;
            for (int i = 0; i < getNormalMoves().length; i++) {
                if ((Utils.index(dx - x, dy - y)) == modifier * getNormalMoves()[i])
                    ans = true;
            }
        } else {
            ans = validHitMove(x, y, dx, dy, board);
        }
        return ans;
    }

    public int[] getNormalMoves() {
        return normalMoves;
    }

    public void setNormalMoves(int[] normalMoves) {
        this.normalMoves = normalMoves;
    }

    private boolean validHitMove(int x, int y, int dx, int dy, Board board) {
        boolean ans = false;
        if (!board.getField(dx, dy).getColor().equalsColor(this.color)) {
            int modifier = color.equalsColor(Color.WHITE) ? -1 : 1;
            for (int i = 0; i < getHitMoves().length; i++) {
                if((Utils.index(dx - x, dy - y)) == modifier * getHitMoves()[i])
                    ans = true;
            }
        }
        return ans;
    }

    public int[] getHitMoves() {
        return hitMoves;
    }

    public void setHitMoves(int[] hitMoves) {
        this.hitMoves = hitMoves;
    }
}
