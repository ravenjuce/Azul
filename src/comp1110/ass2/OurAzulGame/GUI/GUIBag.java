package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.Containers;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Xuanchen Wang
 * This is the GUI bag class
 *
 */
public class GUIBag extends FlowPane {
    public GUIBag() {
        //Set the basic properties of bag
        setLayoutX(750.0);
        setLayoutY(170.0);
        setPrefSize(450.0, 50.0);
        setVgap(3.0);
        setHgap(3.0);
        setAlignment(Pos.BASELINE_CENTER);
        setStyle("-fx-border-color: #fcaf17;-fx-border-width: 5;-fx-border-radius: 15");

        //Initialize the bag with 50 tiles
        init();
    }

    private void init() {
        Random random = new Random();

        //A list to store random integer between 0 and 80
        List<Integer> ran = new ArrayList<>();

        //Get integers between 0 and 80 without duplication
        while (ran.size() < 80) {
            int i = random.nextInt(80);
            if (!ran.contains(i)) {
                ran.add(i);
            }
        }
        if (Containers.Bag.getGroup().size() == 0) {
            for (int i = 0; i < 80; i++) Containers.Bag.getGroup().add(null);
        }

        //Fill the bag with 5 different colors of tile
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 16; j++) {
                switch (i) {
                    case 0 -> {
                        Tile tmp = new Tile("#ed1941");

                        tmp.setGroup(Containers.Bag.getGroup());

                        getChildren().add(tmp);

                        //The tile is randomly placed in the group
                        Containers.Bag.getGroup().set(ran.get(i * 16 + j), tmp);
                    }
                    case 1 -> {
                        Tile tmp1 = new Tile("blue");

                        tmp1.setGroup(Containers.Bag.getGroup());

                        getChildren().add(tmp1);

                        Containers.Bag.getGroup().set(ran.get(i * 16 + j), tmp1);
                    }
                    case 2 -> {
                        Tile tmp2 = new Tile("#1d953f");

                        tmp2.setGroup(Containers.Bag.getGroup());

                        getChildren().add(tmp2);

                        Containers.Bag.getGroup().set(ran.get(i * 16 + j), tmp2);
                    }
                    case 3 -> {
                        Tile tmp3 = new Tile("#fcaf17");

                        tmp3.setGroup(Containers.Bag.getGroup());

                        getChildren().add(tmp3);

                        Containers.Bag.getGroup().set(ran.get(i * 16 + j), tmp3);
                    }
                    case 4 -> {
                        Tile tmp4 = new Tile("#694d9f");

                        tmp4.setGroup(Containers.Bag.getGroup());

                        getChildren().add(tmp4);

                        Containers.Bag.getGroup().set(ran.get(i * 16 + j), tmp4);
                    }
                }

            }
        }
    }

}
