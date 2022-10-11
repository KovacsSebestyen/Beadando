package hu.sebestyen.foxandhounds.service.command;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.service.exception.MapBuildingException;
import hu.sebestyen.foxandhounds.service.exception.ExitException;
import hu.sebestyen.foxandhounds.service.randomhound.RandomHound;

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
        return splitCommand;
    }
    public GameState checkCommand() throws MapBuildingException, ExitException {
        String[] splitedCommand = splitCommand();
        switch (splitedCommand[0]) {
            case "start":
                return gameState = new StartCommand().startGame();
            case "step":
                if(splitedCommand.length==3) {
                    gameState = new StepCommand(gameState, splitedCommand[1], splitedCommand[2]).stepGame();
                    return gameState = new RandomHound(gameState).randomHound();
                }else {
                    System.out.println("Wrong step command!");
                    return gameState;
                }
            case "exit":
                return gameState = new ExitCommand(gameState).exitGame();
            default:
                System.out.println("Unknown command "+splitedCommand[0]);
                return gameState;
        }
    }

}
