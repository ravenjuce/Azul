package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import comp1110.ass2.OurAzulGame.Mosaic;
import comp1110.ass2.OurAzulGame.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: XuanChen Wang
 * A test class to test whether the score a player should get after
 * moving a tile to mosaic is correct
 */
@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)
public class CalculatePointsTest {


    static {
        Actions.currentPlayer = Player.Player1;

    }

    private String errorMessage(int expected, int actual) {
        return "The score should be " + expected + ", but actual score is " + actual;
    }

    @Test
    public void singleTileTest() {
        int score;
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        //No other tiles in the row
        score = Actions.calculatePoints(0, 2);
        assertEquals(1, score, errorMessage(1, score));

        //There is one tile in the row
        mosaic.get(0).set(0, new Tile("blue"));
        score = Actions.calculatePoints(0, 2);
        assertEquals(1, score, errorMessage(1, score));

        //More than one tile in the row
        mosaic.get(2).set(0, new Tile("blue"));
        mosaic.get(2).set(4, new Tile("yellow"));
        score = Actions.calculatePoints(2, 2);
        assertEquals(1, score, errorMessage(1, score));

        //Reset mosaic
        Actions.currentPlayer.mosaic = new Mosaic();


    }

    @Test
    public void onlyRowTest() {
        int score;
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        //One tile in the row
        mosaic.get(0).set(0, new Tile("yellow"));
        score = Actions.calculatePoints(0, 1);
        assertEquals(2, score, errorMessage(2, score));

        //Two tiles in the row
        mosaic.get(0).set(1, new Tile("blue"));
        score = Actions.calculatePoints(0, 2);
        assertEquals(3, score, errorMessage(3, score));

        //Three tiles in the row
        mosaic.get(0).set(3, new Tile("red"));
        score = Actions.calculatePoints(0, 2);
        assertEquals(4, score, errorMessage(4, score));

        //Four tiles in the row
        mosaic.get(0).set(2, new Tile("green"));
        score = Actions.calculatePoints(0, 4);
        assertEquals(5, score, errorMessage(5, score));

        Actions.currentPlayer.mosaic = new Mosaic();


    }

    @Test
    public void onlyColumnTest() {
        int score;
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        //One tile in the column
        mosaic.get(1).set(1, new Tile("blue"));
        score = Actions.calculatePoints(2, 1);
        assertEquals(2, score, errorMessage(2, score));

        //Two tiles in the column
        mosaic.get(0).set(1, new Tile("yellow"));
        score = Actions.calculatePoints(2, 1);
        assertEquals(3, score, errorMessage(3, score));

        //Two tiles are connected to the tile, one isn't
        mosaic.get(4).set(1, new Tile("red"));
        score = Actions.calculatePoints(2, 1);
        assertEquals(3, score, errorMessage(3, score));

        //One tile is connected to the tile, two aren't
        score = Actions.calculatePoints(3, 1);
        assertEquals(2, score, errorMessage(2, score));

        Actions.currentPlayer.mosaic = new Mosaic();

    }

    @Test
    public void bothRowAndColumnTest() {
        int score;
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        //Two tiles in the row and two tiles in the column
        mosaic.get(0).set(0, new Tile("yellow"));
        mosaic.get(0).set(1, new Tile("red"));
        mosaic.get(1).set(2, new Tile("blue"));
        mosaic.get(2).set(2, new Tile("red"));
        score = Actions.calculatePoints(0, 2);
        assertEquals(6, score, errorMessage(6, score));

        //Three tiles in the row and three tiles in the column
        mosaic.get(0).set(2, new Tile("blue"));
        mosaic.get(1).set(3, new Tile("red"));
        mosaic.get(2).set(3, new Tile("yellow"));
        mosaic.get(3).set(3, new Tile("blue"));
        score = Actions.calculatePoints(0, 3);
        assertEquals(8, score, errorMessage(8, score));

        Actions.currentPlayer.mosaic = new Mosaic();


    }
}
