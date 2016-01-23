package chess.piece;

import chess.util.Utils;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class PiecePawn extends Piece {

    int[] normalMoves = { Utils.index(0, 1) };
    int[] hitMoves = { Utils.index(1, 1), Utils.index(-1 , 1)};

    public PiecePawn(Color color) {
        super(color, Type.PAWN);
        setNormalMoves(this.normalMoves);
        setHitMoves(this.hitMoves);
    }
}
