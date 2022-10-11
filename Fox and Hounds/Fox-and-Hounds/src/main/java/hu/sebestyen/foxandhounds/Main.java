package hu.sebestyen.foxandhounds;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.service.command.GameCommands;
import hu.sebestyen.foxandhounds.service.exception.ExitException;
import hu.sebestyen.foxandhounds.service.exception.MapBuildingException;
import hu.sebestyen.foxandhounds.service.validator.Validator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MapBuildingException, ExitException {
        String inCommand="";
        Scanner input = new Scanner(System.in);
        GameState gameState = new GameState(null, false, true,null,null);
        boolean win = false;
        boolean lose = false;
        while(gameState.isPlayerDontWantToExit()&&!win&&!lose) {
            System.out.print("?: ");
            inCommand = input.nextLine();
            gameState = new GameCommands(inCommand, gameState).checkCommand();
            if(gameState.isPlayerDontWantToExit()) {
                System.out.println(gameState.getMapVo().toString());
                win = new Validator(gameState).didYouWin();
                if(win){
                    System.out.println("You Won!");
                }
                lose = new Validator(gameState).didYouLose();
                if(lose){
                    System.out.println("You Lost!");
                }
            }
        }
    }
}