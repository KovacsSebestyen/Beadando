package hu.sebestyen.foxandhounds.service.randomhound;

import hu.sebestyen.foxandhounds.model.GameState;

import java.util.Random;

public class RandomHound {

    private GameState gameState;

    public RandomHound(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState randomHound() {
        Random rand = new Random();
        int size = gameState.getMapVo().getMapSize();
        int[][] hound = gameState.getHounds();
        char[][] map = gameState.getMapVo().getMap();
        int houndNumber;
        int randomStep = 0;
        boolean wrong;
        int max = 0;
        do {
            wrong = false;
            houndNumber = rand.nextInt(size / 2);
            if (hound[houndNumber][0] != size - 1) {
                if (hound[houndNumber][1] == 0) {
                    if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] + 1] == '_') {
                        randomStep = 1;
                    } else {
                        wrong = true;
                    }
                } else if (hound[houndNumber][1] == size - 1) {
                    if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] - 1] == '_') {
                        randomStep = 0;
                    } else {
                        wrong = true;
                    }
                } else if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] + 1] == '_' &&
                        map[hound[houndNumber][0] + 1][hound[houndNumber][1] - 1] == '_') {
                    randomStep = rand.nextInt(2);
                } else if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] + 1] == '_') {
                    randomStep = 1;
                } else if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] - 1] == '_') {
                    randomStep = 0;
                } else {
                    wrong = true;
                }
            } else {
                wrong = true;
            }
            max++;
        } while (wrong && max <= 10);

        if (max < 10) {
            switch (randomStep) {
                case 0:
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = '_';
                    hound[houndNumber][0] += 1;
                    hound[houndNumber][1] -= 1;
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = 'H';
                    gameState.getMapVo().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                case 1:
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = '_';
                    hound[houndNumber][0] += 1;
                    hound[houndNumber][1] += 1;
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = 'H';
                    gameState.getMapVo().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                default:
                    return gameState;
            }
        }
        else {
            return gameState;
        }
    }
}
