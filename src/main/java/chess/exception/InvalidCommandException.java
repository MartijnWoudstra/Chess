package chess.exception;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 29-1-2016
 */
public class InvalidCommandException extends Exception implements ChessException {

    String identifier;
    String command;
    String correctFormat;

    public InvalidCommandException(String identifier, String command, String correctFormat) {
        this.identifier = identifier;
        this.command = command;
        this.correctFormat = correctFormat;
    }

    public void print(){
        System.out.printf("%s %s is not valid not valid for the command %s\n", identifier, command, correctFormat);
    }
}
