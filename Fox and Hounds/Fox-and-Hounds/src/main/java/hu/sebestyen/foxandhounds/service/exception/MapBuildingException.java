package hu.sebestyen.foxandhounds.service.exception;

/**
 * Egy mapbuilding exeption ami egy üzenetet ad vissza.
 */
public class MapBuildingException extends Exception {

    public MapBuildingException(String message) {
        super(message);
    }
}
