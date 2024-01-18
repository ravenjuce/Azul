package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: @Author: Zixin Feng
 * This class indicates the placement area in back-end
 */
public class Placement {
    List<Tile> Group;

    final String groupName = "Placement";

    public List<Tile> getGroup() {
        if (Group == null) {
            Group = new ArrayList<>();

        }
        return Group;
    }


    public String getGroupName() {
        return groupName;
    }

}


