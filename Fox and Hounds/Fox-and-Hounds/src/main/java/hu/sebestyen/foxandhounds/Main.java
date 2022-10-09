package hu.sebestyen.foxandhounds;

import hu.sebestyen.foxandhounds.command.GameCommand;
import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.exeption.MapParsingExeption;
import hu.sebestyen.foxandhounds.service.map.MapParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MapParsingExeption {
        String inCommand="";
        Scanner input = new Scanner(System.in);
        System.out.println("Hello :)\nMagic word?: ");
        inCommand = input.nextLine();

            while(!inCommand.equals("start")) {
                System.out.println("Wrong :(\nTry again:");
                inCommand = input.nextLine();
            }

            MapVO gameMap = null;
            gameMap = new GameCommand(inCommand,gameMap).checkCommand();
            System.out.println(gameMap.toString());

            while(!inCommand.equals("exit")) {
                System.out.println("Next command: ");
                inCommand = input.nextLine();
                gameMap = new GameCommand(inCommand,gameMap).checkCommand();
                if(!inCommand.equals("exit"))System.out.println(gameMap.toString());
            }
        }
}