package hu.sebestyen.foxandhounds.service.command;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.service.exception.MapBuildingException;
import hu.sebestyen.foxandhounds.service.exception.ExitException;

public class GameCommands {

    private String command;
    private GameState gameState;
    private String[] splitCommand;

    public GameCommands(String command, GameState gameState) {
        this.command = command;
        this.gameState = gameState;
    }

    public String[] splitCommand() {
        splitCommand = command.split(" ");
        System.out.println(splitCommand[0]);
        return splitCommand;
    }
    public GameState checkCommand() throws MapBuildingException, ExitException {
        switch (splitCommand()[0]) {
            case "start":
                return gameState = new StartCommand().startGame();
            case "step":
                System.out.println("step");
                return gameState;
            case "exit":
                return gameState = new ExitCommand(gameState).exitGame();
            default:
                System.out.println("Unknown command "+splitCommand()[0]);
                return gameState;
        }
    }

}
