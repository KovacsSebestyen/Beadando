package hu.sebestyen.foxandhounds.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Egy pályát és annak méretét tartalmazza.
 */

public class MapVO {

    private final int mapSize;
    private char[][] map;

    public void setMap(char[][] map) {
        this.map = map;
    }

    public MapVO(int mapSize, char[][] map) {
        this.mapSize = mapSize;
        this.map = deepCopy(map);
    }

    public int getMapSize() {
        return mapSize;
    }

    public char[][] getMap() {
        return deepCopy(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapVO mapVO = (MapVO) o;
        return mapSize == mapVO.mapSize && Arrays.deepEquals(map, mapVO.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mapSize);
        result = 31 * result + Arrays.deepHashCode(map);
        return result;
    }

    @Override
    public String toString() {
        return "Size: " + mapSize +
                ",\nMap:\n" + getMapAsString();
    }

    /**
     * Bekér egy karaktertömböt és minden elmét kimásolja.
     *
     * @param array Egy karakter tömböt kér amit másol.
     * @return A karaktertömb másolata.
     */
    public char[][] deepCopy(char[][] array) {
        char[][] result = null;

        if (array != null) {
            result = new char[array.length][];
            for (int i = 0; i < array.length; i++) {
                result[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }
        return result;
    }

    /**
     *Visszaajda a mapot string ként.
     *
     * @return Vissza adja a kész stringet amit a map-ból csinál.
     */
    public String getMapAsString() {
        String mapString = new String();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                mapString += map[i][j] + " ";
            }
            mapString += "\n";
        }
        return mapString;
    }
}
