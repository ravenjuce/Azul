package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wangyi Li
 * This is the enum indicating the bag, center and discard in back-end
 */
public enum Containers {
    Bag(new ArrayList<>(), "Bag"),
    Center(new ArrayList<>(), "Center"),
    Discard(new ArrayList<>(), "Discard");

    List<Tile> Group;
    String GroupName;

    Containers(List<Tile> Group, String GroupName) {
        this.Group = Group;
        this.GroupName = GroupName;

    }

    public List<Tile> getGroup() {
        return Group;
    }

    public void setGroup(List<Tile> group) {
        Group = group;
    }

    public String getGroupName() {
        return GroupName;
    }
}
