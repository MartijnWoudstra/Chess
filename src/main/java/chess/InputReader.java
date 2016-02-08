package chess;

import chess.board.Board;
import chess.board.Movement;
import chess.piece.Piece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by martijn on 25-1-16.
 */

/**
 * Reader used for test purpose
 */
public class InputReader implements Runnable {

    Board board;

    public InputReader(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean ended = false;
        while(!ended) {
            String line;
            try {
                if((line = reader.readLine()) != null) {
                    Scanner sc = new Scanner(line);
                    String identifier = sc.next();
                    if (identifier.equals("SET")) {//todo lib
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        Piece piece = board.getPiece(x, y);

                        int toX = sc.nextInt();
                        int toY = sc.nextInt();
                        boolean a = board.makeMove(toX, toY, piece);
                        System.out.println(a);
                    }
                    else {
                        System.out.println(Movement.isHorizontalOrVertical(board.getPiece(2, 2), sc.nextInt(), sc.nextInt()));
                    }
                } else {
                    ended = true;
                }
            } catch (IOException | StringIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Use the correct format! Try again");
            }
        }
    }
}
