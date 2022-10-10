package hu.sebestyen.foxandhounds.service.command;

import hu.sebestyen.foxandhounds.model.GameState;
import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.exception.MapBuildingException;
import hu.sebestyen.foxandhounds.service.map.MapBuilder;

import java.util.Scanner;

public class StartCommand {

    public GameState startGame() throws MapBuildingException {
        int size=0;
        GameState startGameMap = new GameState(null,true, true,null,null);
        MapVO createdMap;
        int[] fox = new int[2];
        int[][] hounds;
        Scanner input = new Scanner(System.in);
        System.out.println("?Size?: ");
        size = Integer.parseInt(input.nextLine());
        hounds = new int[size/2][2];
        for (int i = 1; i < size; i+=2) {
            hounds[i/2][0]=0;
            hounds[i/2][1]=i;
        }
        fox[0]=size-1;
        fox[1]=0;
        createdMap = new MapBuilder(size).build();
        startGameMap.setFox(fox);
        startGameMap.setHounds(hounds);
        startGameMap.setMapVo(createdMap);
        return startGameMap;
    }
}
