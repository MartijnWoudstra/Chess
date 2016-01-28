package chess;

import chess.board.Board;
import chess.player.Player;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Start {
    public static void main(String[] args) {
        ;
        Board board = new Board();
        Player player = new Player(true, "martijn");
        board.addPlayer(player);
        Player player2 = new Player(false, "nietMartijn");
        board.addPlayer(player2);
        Thread t = new Thread(new InputReader(board));
        t.start();
    }
}
