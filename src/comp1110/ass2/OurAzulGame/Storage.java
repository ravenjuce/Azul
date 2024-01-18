package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: @Author: Wangyi Li
 * This class indicates the storage area in back-end
 */
public class Storage {

    List<ArrayList<Tile>> Group;

    final String groupName = "Storage";


    public List<ArrayList<Tile>> getGroup() {
        if (Group == null) {
            //Initialize group
            Group = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Group.add(new ArrayList<>());
            }

        }
        return Group;
    }


    public String getGroupName() {
        return groupName;
    }

}
