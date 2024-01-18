package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.Containers;
import comp1110.ass2.OurAzulGame.Factory;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)
public class ClickTest {
    //Get two groups
    static List<Tile> factoryGroup0 = Factory.getGroup().get(0);
    static List<Tile> centerGroup = Containers.Center.getGroup();

    //Creat a tile to click
    TestFactoryTile blue = new TestFactoryTile("blue");


    private String errorPrefix(int correct, int notCorrect, String place) {
        return "There should be " + correct + " tiles in " + place + ", but " + notCorrect + " tiles are in the " + place + " now.";
    }

    @Test
    public void testClickInFactory() {
        System.out.println("4 blue tiles in factory");
        testTile(new String[]{"blue", "blue", "blue"}, "Factory");

        System.out.println("3 blue tiles, 1 red tile in factory");
        testTile(new String[]{"blue", "blue", "red"}, "Factory");

        System.out.println("2 blue tiles, 2 red tiles in factory");
        testTile(new String[]{"blue", "red", "red"}, "Factory");

        System.out.println("2 blue tiles, 1 red tile, 1 yellow tile in factory");
        testTile(new String[]{"blue", "yellow", "red"}, "Factory");

        System.out.println("1 blue tile, 2 red tiles, 1 yellow tile in factory");
        testTile(new String[]{"red", "yellow", "red"}, "Factory");

        System.out.println("1 blue tile, 1 red tile, 1 yellow,1 green tile in factory");
        testTile(new String[]{"red", "yellow", "green"}, "Factory");


    }

    @Test
    public void testClickInCenter() {
        System.out.println("4 blue tiles in center");
        testTile(new String[]{"blue", "blue", "blue"}, "Center");

        System.out.println("3 blue tiles, 1 red tile in center");
        testTile(new String[]{"blue", "blue", "red"}, "Center");

        System.out.println("2 blue tiles, 2 red tiles in center");
        testTile(new String[]{"blue", "red", "red"}, "Center");

        System.out.println("2 blue tiles, 1 red tile, 1 yellow tile in center");
        testTile(new String[]{"blue", "yellow", "red"}, "Center");

        System.out.println("1 blue tile, 2 red tiles, 1 yellow tile in center");
        testTile(new String[]{"red", "yellow", "red"}, "Center");

        System.out.println("1 blue tile, 1 red tile, 1 yellow,1 green tile in center");
        testTile(new String[]{"red", "yellow", "green"}, "Center");


    }

    private void testTile(String[] colors, String place) {
        //The number of tiles in center
        int number = 0;

        //If click in factory
        if (place.equals("Factory")) {
            for (int i = 0; i < 3; i++) if (!colors[i].equals("blue")) number++;

            //Add tiles to factory
            factoryGroup0.addAll(Arrays.asList(blue, new TestFactoryTile(colors[0]), new TestFactoryTile(colors[1]), new TestFactoryTile(colors[2])));
        } else {
            number = 3;
            for (int i = 0; i < 3; i++) if (colors[i].equals("blue")) number--;

            //Add tiles to center
            factoryGroup0.addAll(Arrays.asList(blue, new TestCenterTile(colors[0]), new TestCenterTile(colors[1]), new TestCenterTile(colors[2])));
        }


        //Do click action
        Actions.clickInFactory(blue);

        assertEquals(0, factoryGroup0.size(), errorPrefix(0, factoryGroup0.size(), "factory"));
        System.out.println("Factory test passed");

        assertEquals(number, centerGroup.size(), errorPrefix(0, factoryGroup0.size(), "center"));
        System.out.println("Center test passed");
        System.out.println();

        //The factory and center is used by all players, clear them after the test
        factoryGroup0.removeAll(factoryGroup0);
        centerGroup.removeAll(centerGroup);
    }

    /*
     *An inner class in order to simulate tiles in factory
     * */
    static class TestFactoryTile extends Tile {
        TestFactoryTile(String color) {
            super(color);
            setGroup(factoryGroup0);
            setGroupName("group0");
        }
    }

    /*
     *An inner class in order to simulate tiles in center
     * */
    static class TestCenterTile extends Tile {
        TestCenterTile(String color) {
            super(color);
            setGroup(centerGroup);
            setGroupName("Center");
        }
    }
}

