package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: @Author: Wangyi Li
 *  Factory is shared by all players,all the fields and methods are static in this class
 *
 */

public class Factory {
    static List<ArrayList<Tile>> Group;
    static final List<String> GroupName = new ArrayList<>(Arrays.asList("group0", "group1", "group2", "group3", "group4", "group5", "group6", "group7", "group8"));
    public static List<String> getGroupName() {
        return GroupName;
    }

    public static List<ArrayList<Tile>> getGroup() {
        if (Group == null) {
            Group = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                Group.add(new ArrayList<>());
            }
        }
        return Group;
    }

}
