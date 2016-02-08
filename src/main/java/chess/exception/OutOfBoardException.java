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
public class OutOfBoardException extends Exception implements ChessException {

    Set<Integer> arguments = new HashSet<Integer>();

    public OutOfBoardException(int... args){
        for(int arg : args){
            arguments.add(arg);
        }
    }

    public void print(){
        System.out.printf("The location(s) ");
        arguments.stream().filter(param -> param > Board.DIM).forEach(param -> System.out.print(param + " "));
        System.out.print("is/are out of the board dimention!\n");
    }
}
