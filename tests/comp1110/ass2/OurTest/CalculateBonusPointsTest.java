package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.GUI.Locations;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import comp1110.ass2.OurAzulGame.Mosaic;
import comp1110.ass2.OurAzulGame.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: Xuanchen Wang
 * This is a class to test whether the function of calculating bonus points
 * works well
 */
@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)
public class CalculateBonusPointsTest {

    static {
        Actions.currentPlayer = Player.Player1;
        Locations.player = 2;
        Actions.link(2);
    }

    private String errorMessage(int expected, int actual) {
        return "The score should be " + expected + ", but actual score is " + actual;
    }

    @Test
    public void oneRowCompletedTest() {
        //Fill one row
        fillOneRow(0);

        //Initialize score
        Actions.currentPlayer.score = 0;

        Actions.calculateBonusPoints();

        int score = Actions.currentPlayer.score;
        assertEquals(2, score, errorMessage(2, score));

        Actions.currentPlayer.mosaic = new Mosaic();


    }

    @Test
    public void twoRowsCompletedTest() {
        //Fill two rows
        fillOneRow(0);
        fillOneRow(1);

        Actions.currentPlayer.score = 0;

        Actions.calculateBonusPoints();

        int score = Actions.currentPlayer.score;
        assertEquals(4, score, errorMessage(4, score));

        Actions.currentPlayer.mosaic = new Mosaic();

    }

    @Test
    public void oneColumnCompletedTest() {
        fillOneColumn(0);

        Actions.currentPlayer.score = 0;

        Actions.calculateBonusPoints();

        int score = Actions.currentPlayer.score;
        assertEquals(7, score, errorMessage(7, score));

        Actions.currentPlayer.mosaic = new Mosaic();

    }

    @Test
    public void TowColumnsCompletedTest() {
        fillOneColumn(0);
        fillOneColumn(1);

        Actions.currentPlayer.score = 0;

        Actions.calculateBonusPoints();

        int score = Actions.currentPlayer.score;
        assertEquals(14, score, errorMessage(14, score));

        Actions.currentPlayer.mosaic = new Mosaic();

    }

    @Test
    public void FiveTilesInSameColorTest() {
        fillFiveTilesInSameColor("blue");

        Actions.currentPlayer.score = 0;

        Actions.calculateBonusPoints();

        int score = Actions.currentPlayer.score;
        assertEquals(10, score, errorMessage(10, score));

        Actions.currentPlayer.mosaic = new Mosaic();

    }




    private void fillOneRow(int row) {
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();
        String[] colors = {"blue", "#1d953f", "#fcaf17", "#694d9f", "#ed1941"};

        for (int i = 0; i < 5; i++) {
            mosaic.get(row).set(i, new Tile(colors[(row + i) % 5]));
        }
    }

    private void fillOneColumn(int column) {
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();
        String[] colors = {"blue", "#1d953f", "#fcaf17", "#694d9f", "#ed1941"};

        for (int i = 0; i < 5; i++) {
            mosaic.get(i).set(column, new Tile(colors[(column + i) % 5]));
        }
    }

    private void fillFiveTilesInSameColor(String color) {
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        for (int i = 0; i < 5; i++) {
            mosaic.get(i).set(i, new Tile(color));
        }
    }

}
