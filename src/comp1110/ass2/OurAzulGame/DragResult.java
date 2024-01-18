package comp1110.ass2.OurAzulGame;

/**
 * @Author: Xuanchen Wang
 * This is a class to store the different parameters we need from drag available methods
 */
public class DragResult {
    boolean flag;
    boolean nextPlayer;
    Double CoordX;
    Double CoordY;
    Integer row;
    Integer columnInMosaic;


    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Double getCoordX() {
        return CoordX;
    }

    public void setCoordX(Double coordX) {
        CoordX = coordX;
    }

    public Double getCoordY() {
        return CoordY;
    }

    public void setCoordY(Double coordY) {
        CoordY = coordY;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public boolean isNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(boolean nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public int getColumnInMosaic() {
        return columnInMosaic;
    }

    public void setColumnInMosaic(Integer columnInMosaic) {
        this.columnInMosaic = columnInMosaic;
    }


}
