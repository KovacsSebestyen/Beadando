package hu.sebestyen.foxandhounds.service.command;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.service.exception.ExitException;

/**
 * Ez az osztály az exit parancsot működteti.
 */
public class ExitCommand {

    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Az az eljárás megnézi hogy milyen módon használja az exit parancsot.
     *
     * @return Vissza adja a jelenlegi játékállást.
     * @throws ExitException Akkor dobja ha a játék elindítása előtt akar kilépni a játékos.
     */
    public GameState exitGame() throws ExitException {
        if (gameState.isMapExist()) {
            gameState.setPlayerDontWantToExit(false);
            return gameState;
        } else {
            throw new ExitException("ok bye :)");
        }
    }
}
