package chess;

import chess.board.Board;
import chess.exception.InvalidCommandException;
import chess.lib.CommandLib;
import chess.lib.ErrorLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by martijn on 25-1-16.
 */

/**
 * Reader used for test purpose
 */
public class InputReader implements Runnable {

    private Board board;

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
                    String identifier;
                    try{
                        if((identifier = sc.next()) != null){
                            switchCommand(identifier, sc.nextLine());
                        }
                    }  catch (InvalidCommandException e) {
                        e.print();
                    } catch (NoSuchElementException e){
                        System.out.println(ErrorLib.INVALID_INPUT);
                    }
                } else {
                    ended = true;
                }
            } catch (IOException | StringIndexOutOfBoundsException e) {
                e.printStackTrace();
                ended = true;
            }
        }
    }

    /**
     * Detects what command needs to be executed, and called the specific method.
     *
     * @see {@link #run}
     * @param identifier the identifier for the command
     * @param command everything after the identifer. Usually command arguments
     * @throws InvalidCommandException when an invalid command is entered.
     */
    private void switchCommand(String identifier, String command) throws InvalidCommandException{
        switch (identifier.toUpperCase()) {
            case CommandLib.SET: {
                executeSetCommand(command);
            }
        }
    }

    /**
     * Executes the set command
     *
     * @see {@link chess.lib.ErrorLib}
     * @param command command parameters, given as one string.
     * @throws InvalidCommandException
     */
    private void executeSetCommand(String command) throws InvalidCommandException {
        Scanner sc = new Scanner(command);
        int x;
        int y;
        int toX;
        int toY;
        try {
            x = sc.nextInt();
            y = sc.nextInt();
            toX = sc.nextInt();
            toY = sc.nextInt();
        }
        catch (NoSuchElementException e) {
            throw new InvalidCommandException(CommandLib.SET, command, CommandLib.SET_COMMAND);
        }
        boolean a = board.makeMove(x, y, toX, toY, board.getPiece(x, y));
        if (a) System.out.printf("Move made from (%d, %d) to (%d, %d)%n", x, y, toX, toY);
        else System.out.printf("Invalid move from (%d, %d) to (%d, %d)%n", x, y, toX, toY);
    }
}