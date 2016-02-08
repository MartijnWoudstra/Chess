import chess.InputReader;
import chess.board.Board;
import chess.player.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by martijn on 28-1-16.
 */
public class ChessTest {

    Board board;
    Player player1;
    Player player2;

    @Before
    public void setup(){
        board = new Board();
        player1 = new Player(true, "martijn");
        board.addPlayer(player1);
        player2 = new Player(false, "nietMartijn");
        board.addPlayer(player2);
        Thread t = new Thread(new InputReader(board));
        t.start();
    }

    @Test
    public void testMove(){
        player1.makeMove(7, 7, 7, 6);
    }
}
