package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import comp1110.ass2.OurAzulGame.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)

public class DragAvailableInStorageTest {
    // Lists that store coordinates used in test
    List<Double[]> LegalCoordInStorage = new ArrayList<>();
    List<Double[]> IllegalCoordInStorage = new ArrayList<>();

    Tile tile;

    @Test
    public void testAllEmptyInStorage() {
        // Initialize lists
        LegalCoordInStorage.addAll(Arrays.asList(
                new Double[]{390.0, 300.0},
                new Double[]{390.0, 345.0},
                new Double[]{390.0, 370.0},
                new Double[]{390.0, 430.0},
                new Double[]{390.0, 490.0}
        ));
        IllegalCoordInStorage.addAll(Arrays.asList(
                new Double[]{390.0, 10.0},
                new Double[]{330.0, 300.0},
                new Double[]{280.0, 600.0},
                new Double[]{245.0, 230.0},
                new Double[]{330.0, 345.0},
                new Double[]{330.0, 370.0},
                new Double[]{280.0, 430.0},
                new Double[]{280.0, 485.0},
                new Double[]{245.0, 430.0},
                new Double[]{205.0, 480.0},
                new Double[]{205.0, 80.0}
        ));

        for (Double[] tmp : LegalCoordInStorage) {
            tile = new Tile("yellow");
            tile.setLayoutX(tmp[0]);
            tile.setLayoutY(tmp[0]);

            boolean result = Actions.DragAvailableInStorage(tile).getFlag();

            assertTrue(result, "Input coordinate x = " + tmp[0] + " y = " + tmp[1] + " is legal, but the result is illegal");
        }

        for (Double[] tmp : IllegalCoordInStorage) {
            tile = new Tile("yellow");
            tile.setLayoutX(tmp[0]);
            tile.setLayoutY(tmp[0]);

            boolean result = Actions.DragAvailableInStorage(tile).getFlag();

            assertFalse(result, "Input coordinate x = " + tmp[0] + " y = " + tmp[1] + " is illegal, but the result is legal");
        }
    }

    @Test
    public void testEachRowWithOneTile() {
        // Initialize lists
        LegalCoordInStorage.addAll(Arrays.asList(
                new Double[]{335.0, 345.0},
                new Double[]{335.0, 370.0},
                new Double[]{335.0, 430.0},
                new Double[]{335.0, 490.0}
        ));
        IllegalCoordInStorage.addAll(Arrays.asList(
                new Double[]{390.0, 300.0},
                new Double[]{390.0, 345.0},
                new Double[]{390.0, 370.0},
                new Double[]{390.0, 430.0},
                new Double[]{390.0, 490.0},
                new Double[]{335.0, 300.0},
                new Double[]{290.0, 370.0},
                new Double[]{290.0, 430.0},
                new Double[]{290.0, 490.0},
                new Double[]{245.0, 430.0},
                new Double[]{245.0, 490.0},
                new Double[]{200.0, 490.0}
        ));

        // Add a tile to each row
        for (int i = 0; i < 5; i++) Player.Player1.storage.getGroup().get(i).add(new Tile("yellow"));

        for (Double[] tmp : LegalCoordInStorage) {
            tile = new Tile("yellow");
            tile.setLayoutX(tmp[0]);
            tile.setLayoutY(tmp[0]);

            boolean result = Actions.DragAvailableInStorage(tile).getFlag();

            assertTrue(result, "Input coordinate x = " + tmp[0] + " y = " + tmp[1] + " is legal, but the result is illegal");
        }

        for (Double[] tmp : IllegalCoordInStorage) {
            tile = new Tile("yellow");
            tile.setLayoutX(tmp[0]);
            tile.setLayoutY(tmp[0]);

            boolean result = Actions.DragAvailableInStorage(tile).getFlag();

            assertFalse(result, "Input coordinate x = " + tmp[0] + " y = " + tmp[1] + " is illegal, but the result is legal");
        }

        for (int i = 0; i < 5; i++) {
            Player.Player1.storage.getGroup().get(i).remove(0);
        }
    }

    @Test
    public void testDifferentColorTileInSameRow() {
        // Initialize lists
        LegalCoordInStorage.addAll(Arrays.asList(
                new Double[]{335.0, 345.0},
                new Double[]{335.0, 370.0},
                new Double[]{335.0, 430.0},
                new Double[]{335.0, 490.0}
        ));

        // Add a tile to each row
        for (int i = 0; i < 5; i++) Player.Player1.storage.getGroup().get(i).add(new Tile("red"));

        for (Double[] tmp : LegalCoordInStorage) {
            //The color is different
            tile = new Tile("yellow");
            tile.setLayoutX(tmp[0]);
            tile.setLayoutY(tmp[0]);

            boolean result = Actions.DragAvailableInStorage(tile).getFlag();

            assertFalse(result, "Input coordinate x = " + tmp[0] + " y = " + tmp[1] + " with color yellow is illegal, but the result is legal");
        }

        // Remove the tile from storage after the test
        for (int i = 0; i < 5; i++) {
            Player.Player1.storage.getGroup().get(i).remove(0);
        }
    }


}

