package hu.sebestyen.foxandhounds.service.validator;

import hu.sebestyen.foxandhounds.model.GameState;

/**
 * Ez az osztály ellenőrzi hogy a játékos egy lépés után nyert- vagy vesztett-e.
 */
public class Validator {
    private GameState gameState;
    private boolean win = false;
    private boolean lose = false;
    private int[] fox;
    private int size;
    private char[][] map;

    public Validator(GameState gameState) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
    }

    /**
     * Ez az függvény vizsgálja meg, hogy a játékos nyert-e.
     *
     * @return Egy logikai értéket ad vissza az alapján, hogy nyert-e a játékos.
     */
    public boolean didYouWin() {
        if (fox[0] == 0) {
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    /**
     * Ez az függvény vizsgálja meg, hogy a játékos vesztett-e.
     *
     * @return Egy logikai értéket ad vissza az alapján, hogy vesztett-e a játékos.
     */
    public boolean didYouLose() {
        if (fox[0] == size - 1 && fox[1] == 0) {
            if (map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[0] == 0 && fox[1] == size - 1) {
            lose = false;
        } else if (fox[0] == 0) {
            lose = false;
        } else if (fox[0] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == 0) {
            if (map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H' &&
                    map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        }
        return lose;
    }
}
