package hu.sebestyen.foxandhounds.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {

    private final int mapSize;
    private final char[][] map;
    private final boolean[][] closed;

    public MapVO(int mapSize, char[][] map, boolean[][] closed) {
        this.mapSize = mapSize;
        this.map = deepCopy(map);
        this.closed = deepCopy(closed);
    }

    public int getNumberOfRows() {
        return mapSize;
    }

    public char[][] getMap() {
        return deepCopy(map);
    }

    public boolean[][] getClosed() {
        return deepCopy(closed);
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
        return mapSize == mapVO.mapSize && Arrays.deepEquals(map, mapVO.map) && Arrays.deepEquals(closed, mapVO.closed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mapSize);
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(closed);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + mapSize +
                ", map=" + Arrays.toString(map) +
                ", closed=" + Arrays.toString(closed) +
                '}';
    }

    public char[][] deepCopy(char[][] array) {
        char[][] result= null;

        if(array != null){
            result = new char[array.length][];
            for(int i=0;i < array.length;i++){
                result[i] = Arrays.copyOf(array[i],array[i].length);
            }
        }
        return result;
    }

    public boolean[][] deepCopy(boolean[][] array) {
        boolean[][] result = null;

        if(array != null) {
            result = new boolean[array.length][];
            for (int i=0; i < array.length;i++){
                result[i] = Arrays.copyOf(array[i],array[i].length);
            }
        }
        return result;
    }
}
