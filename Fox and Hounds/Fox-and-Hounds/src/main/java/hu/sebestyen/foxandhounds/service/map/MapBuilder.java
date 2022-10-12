package hu.sebestyen.foxandhounds.service.map;

import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.exception.MapBuildingException;

/**
 * Ez az osztály felelős a pálya megfelelő létrehozásához.
 */
public class MapBuilder {

    private final int mapSize;

    public MapBuilder(int mapSize) {

        this.mapSize = mapSize;
    }

    /**
     * Ellenőrzi a pályának megadott méretet és elkészíti a pályát.
     *
     * @return Vissza adja az elkészített pályát és annak méretét.
     * @throws MapBuildingException Akkor dobja ha a megadott pálya méret nem megfelelő.
     */
    public MapVO build() throws MapBuildingException {

        checkSize(mapSize);

        char[][] map = getMap();

        return new MapVO(mapSize, map);
    }

    /**
     * Ellenőrzi, hogy a megadott méret a pályának megfelelő-e.
     *
     * @param mapSize Bekéri a megadott méretet.
     * @throws MapBuildingException Akkor dobja ha a megadott méret nem megfelelő.
     */
    public void checkSize(int mapSize) throws MapBuildingException {
        if (mapSize < 4) {
            throw new MapBuildingException("Size of map has to be minimum 4!");
        }
        if (mapSize > 12) {
            throw new MapBuildingException("Size of map has to be maximum 12!");
        }
        if (mapSize % 2 != 0) {
            throw new MapBuildingException("Size of map has to be even number!");
        }
    }

    /**
     *  Elkészíti a pályát.
     *
     * @return Vissza adja az elkészített pályát.
     */
    public char[][] getMap() {
        char[][] map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            if (i == 0) {
                for (int j = 0; j < mapSize; j++) {
                    if (j % 2 != 0) {
                        map[i][j] = 'H';
                    } else {
                        map[i][j] = 'X';
                    }
                }
            } else {
                for (int j = 0; j < mapSize; j++) {
                    if (i % 2 != 0) {
                        if (j % 2 == 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    } else {
                        if (j % 2 != 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    }
                }
            }
        }
        map[mapSize - 1][0] = 'F';
        return map;
    }
}
