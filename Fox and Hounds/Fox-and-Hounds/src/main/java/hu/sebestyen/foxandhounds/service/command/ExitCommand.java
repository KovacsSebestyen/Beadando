package hu.sebestyen.foxandhounds.service.command;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.service.exception.ExitException;

public class ExitCommand {

    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState exitGame() throws ExitException {
        if(gameState.isMapExist()){
            gameState.setPlayerDontWantToExit(false);
            return gameState;
        }
        else{
            throw new ExitException("ok bye :)");
        }
    }
}
