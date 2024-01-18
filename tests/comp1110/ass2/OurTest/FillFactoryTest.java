package comp1110.ass2.OurTest;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.Containers;
import comp1110.ass2.OurAzulGame.Factory;
import comp1110.ass2.OurAzulGame.GUI.GUIActions;
import comp1110.ass2.OurAzulGame.GUI.Locations;
import comp1110.ass2.OurAzulGame.GUI.Tile;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@org.junit.jupiter.api.Timeout(value = 5000, unit = MILLISECONDS)
public class FillFactoryTest {
    //Correct tile numbers with different player numbers if the factory is fully filled
    static final int[] CorrectNumber = {20, 28, 36};

    private String errorPrefix(int correct, int notCorrect) {
        return "There should be " + correct + " tiles in factory, but " + notCorrect + " tiles are in the factory now.";
    }

    @Test
    public void testEnoughTilesInBag() {
        //Set player number
        Locations.player = 2;
        test(0,50,0);

        //Set player number
        Locations.player = 3;
        test(1,50,0);

        //Set player number
        Locations.player = 4;
        test(2,50,0);

    }

    @Test
    public void testInsufficientTilesInBag() {

        //Set player number
        Locations.player = 2;
        test(0,10,30);

        //Set player number
        Locations.player = 3;
        test(1,10,30);

        //Set player number
        Locations.player = 4;
        test(2,10,30);


    }

    private void test(int playerNumber, int tileInBag, int tileInDiscard) {
        //Get the bag group and fill the bag with tiles
        List<Tile> bagGroup = Containers.Bag.getGroup();
        for (int i = 0; i < tileInBag; i++) bagGroup.add(new Tile("black"));

        //Get the bag group and fill the bag with tiles
        List<Tile> discardGroup = Containers.Discard.getGroup();
        for (int i = 0; i < tileInDiscard; i++) bagGroup.add(new Tile("black"));

        GUIActions.FillFactory(new AnchorPane());

        //Get real tile number in factory
        int number = 0;
        List<ArrayList<Tile>> group = Factory.getGroup();
        for (ArrayList<Tile> tmp : group) {
            number += tmp.size();

            //The factory is shared by all players, clear the factory after each test
            tmp.removeAll(tmp);

        }
        assertEquals(CorrectNumber[playerNumber], number, errorPrefix(CorrectNumber[playerNumber], number));
        //The bag is shared by all players, clear the bag after test
        bagGroup.removeAll(bagGroup);

    }


}
