package hu.sebestyen.foxandhounds.service.exception;

/**
 * Egy exit exeption ami egy üzenetet ad vissza.
 */
public class ExitException extends Exception {
    public ExitException(String message) {
        super(message);
    }
}
