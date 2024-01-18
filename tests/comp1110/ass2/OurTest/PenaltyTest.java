package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.Floor;
import comp1110.ass2.OurAzulGame.GUI.GUICenter;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import comp1110.ass2.OurAzulGame.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: Xuanchen Wang
 * This is a class to test penalty function
 */
@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)
public class PenaltyTest {

    static {
        Actions.currentPlayer = Player.Player1;
    }

    private String errorMessage(int expected, int actual) {
        return "The score should be " + expected + ", but actual score is " + actual;
    }

    @Test
    public void firstPlayerTest() {
        List<Tile> floor = Actions.currentPlayer.floor.getGroup();

        floor.add(GUICenter.getOne());
        test(1);

        Actions.currentPlayer.floor = new Floor();

    }

    @Test
    public void twoTilesFloorTest() {
        List<Tile> floor = Actions.currentPlayer.floor.getGroup();

        floor.add(new Tile("yellow"));
        floor.add(new Tile("yellow"));

        test(2);

        Actions.currentPlayer.floor = new Floor();


    }

    @Test
    public void threeTilesTest() {
        List<Tile> floor = Actions.currentPlayer.floor.getGroup();

        floor.add(new Tile("yellow"));
        floor.add(new Tile("yellow"));
        floor.add(new Tile("blue"));

        test(4);

        Actions.currentPlayer.floor = new Floor();
    }

    @Test
    public void sevenAndMoreTilesTest() {
        List<Tile> floor = Actions.currentPlayer.floor.getGroup();

        floor.add(new Tile("yellow"));
        floor.add(new Tile("yellow"));
        floor.add(new Tile("blue"));
        floor.add(new Tile("blue"));
        floor.add(new Tile("blue"));
        floor.add(new Tile("red"));
        floor.add(new Tile("red"));
        test(14);

        floor.add(new Tile("red"));
        floor.add(new Tile("red"));
        floor.add(new Tile("red"));
        test(14);

        Actions.currentPlayer.floor = new Floor();
    }

    @Test
    public void noNegativePointTest() {
        List<Tile> floor = Actions.currentPlayer.floor.getGroup();


        floor.add(new Tile("yellow"));
        floor.add(new Tile("yellow"));
        test(1);

        floor.add(new Tile("blue"));
        floor.add(new Tile("yellow"));
        floor.add(new Tile("yellow"));
        floor.add(new Tile("blue"));
        test(5);

        Actions.currentPlayer.floor = new Floor();


    }


    private void test(int i) {
        Actions.currentPlayer.score = i;

        Actions.penalty();

        int score = Actions.currentPlayer.score;
        assertEquals(0, score, errorMessage(0, score));


    }


}
