package hu.sebestyen.foxandhounds.command;

import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.exeption.MapParsingExeption;
import hu.sebestyen.foxandhounds.service.map.MapBuilder;

import java.util.Scanner;

public class GameCommand {

    private String command;
    private MapVO gameMap;
    private String[] splitCommand;

    public GameCommand(String command, MapVO gameMap) {
        this.command = command;
        this.gameMap = gameMap;
    }

    public String[] splitCommand() {
        splitCommand = command.split(" ");
        System.out.println(splitCommand[0]);
        return splitCommand;
    }
    public MapVO checkCommand() throws MapParsingExeption {
        switch (splitCommand()[0]) {
            case "start":
                return gameMap = startGame();
            case "step":
                System.out.println("step");
                return gameMap;
            case "exit":
                return gameMap;
            default:
                System.out.println("Unknown command "+splitCommand()[0]);
                return gameMap;
        }
    }

    private MapVO startGame() throws MapParsingExeption{
        int size=0;
        MapVO startGameMap;
        Scanner input = new Scanner(System.in);
        System.out.println("?Size?: ");
        size = Integer.parseInt(input.nextLine());
        return startGameMap = new MapBuilder(size).build();
    }
}
