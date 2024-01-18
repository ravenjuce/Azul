package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: @Author: Zixin Feng
 * This class indicates the mosaic area in back-end
 */
public class Mosaic {
    //List to store tiles in mosaic
    List<ArrayList<Tile>> Group;
    final String groupName = "Mosaic";

    public List<ArrayList<Tile>> getGroup() {
        if (Group == null) {
            //Initialize the group with null
            Group = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ArrayList<Tile> tmp = new ArrayList<>();
                for (int j = 0; j < 5; j++) tmp.add(null);
                Group.add(tmp);
            }
        }

        return Group;
    }


    public String getGroupName() {
        return groupName;
    }

}
