package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: @Author: Xuanchen Wang
 * This class indicates players in back-end
 */
public enum Player {
    Player1(new Storage(), new Mosaic(), new Floor(), new Placement(),"Player1"),
    Player2(new Storage(), new Mosaic(), new Floor(), new Placement(),"Player2"),
    Player3(new Storage(), new Mosaic(), new Floor(), new Placement(),"Player3"),
    Player4(new Storage(), new Mosaic(), new Floor(), new Placement(),"Player4");

    public Storage storage;
    public Mosaic mosaic;
    public Floor floor;
    public Placement placement;
    public Player nextPlayer;
    public int score;
    public String name;
    public int completeRow;

    //Store all right most tiles need to be moved to mosaic
    public List<Integer> rightMost;


    Player(Storage storage, Mosaic mosaic, Floor floor, Placement placement,String name) {
        this.storage = storage;
        this.mosaic = mosaic;
        this.floor = floor;
        this.placement = placement;
        this.name = name;

        rightMost = new ArrayList<>();

        completeRow = 0;

        for (int i = 0; i < 5; i++) {
            rightMost.add(null);
        }


    }
}
