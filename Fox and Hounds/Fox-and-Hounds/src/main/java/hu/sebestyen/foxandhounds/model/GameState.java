package hu.sebestyen.foxandhounds.model;

public class GameState {
    private MapVO MapVo;
    private boolean isMapExist;
    private boolean playerDontWantToExit;
    private int[] fox;
    private int[][] hounds;

    public GameState(MapVO mapVo, boolean isMapExist, boolean playerDontWantToExit, int[] fox, int[][] hounds) {
        MapVo = mapVo;
        this.isMapExist = isMapExist;
        this.playerDontWantToExit = playerDontWantToExit;
        this.fox = fox;
        this.hounds = hounds;
    }

    public int[] getFox() {
        return fox;
    }

    public void setFox(int[] fox) {
        this.fox = fox;
    }

    public int[][] getHounds() {
        return hounds;
    }

    public void setHounds(int[][] hounds) {
        this.hounds = hounds;
    }
    public boolean isMapExist() {
        return isMapExist;
    }

    public void setMapExist(boolean mapExist) {
        isMapExist = mapExist;
    }

    public MapVO getMapVo() {
        return MapVo;
    }

    public void setMapVo(MapVO mapVo) {
        MapVo = mapVo;
    }

    public boolean isPlayerDontWantToExit() {
        return playerDontWantToExit;
    }

    public void setPlayerDontWantToExit(boolean playerDontWantToExit) {
        this.playerDontWantToExit = playerDontWantToExit;
    }
}
