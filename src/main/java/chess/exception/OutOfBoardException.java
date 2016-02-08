package chess.exception;

import chess.board.Board;

import java.util.HashSet;
import java.util.Set;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 29-1-2016
 */
public class OutOfBoardException extends InvalidMoveException implements ChessException {

    Set<Integer> arguments = new HashSet<Integer>();

    public OutOfBoardException(int toX, int toY){
        super(toX, toY);
        if(toX < 0 || toX > Board.DIM)
            arguments.add(toX);
        if(toY < 0 || toY > Board.DIM)
            arguments.add(toY);
        setMessage(getMessage());
    }

    public String getMessage(){
        String message = "The location(s) ";
        for(int a : arguments)
            message += a + " ";
        message += "is/are out of the board dimention!\n";
        return message;
    }
}
