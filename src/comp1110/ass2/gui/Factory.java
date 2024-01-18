package comp1110.ass2.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {
    static List<ArrayList<Tile>> Group = null;
    static final List<String> GroupName = new ArrayList<>(Arrays.asList("group0", "group1", "group2", "group3", "group4", "group5", "group6", "group7", "group8"));
    public static int player;
    static List<ArrayList<Double>> CoordX;
    static List<ArrayList<Double>> CoordY;

    public static List<String> getGroupName() {
        return GroupName;
    }

    public static List<ArrayList<Tile>> getGroup() {
        if (Group == null) {
            Group = new ArrayList();
            for (int i = 0; i < 9; i++) {
                Group.add(new ArrayList<>());
            }
        }
        return Group;
    }

    public static List<ArrayList<Double>> getCoordX() {
        CoordX = new ArrayList<>();
        if (player == 3 || player == 4) {
            CoordX.add(new ArrayList<>(Arrays.asList(0.0, 45.0, 0.0, 45.0)));
            CoordX.add(new ArrayList<>(Arrays.asList(105.0, 150.0, 105.0, 150.0)));

        }
        CoordX.add(new ArrayList<>(Arrays.asList(210.0, 235.0, 210.0, 235.0)));
        CoordX.add(new ArrayList<>(Arrays.asList(275.0, 300.0, 275.0, 300.0)));
        CoordX.add(new ArrayList<>(Arrays.asList(340.0, 365.0, 340.0, 365.0)));
        CoordX.add(new ArrayList<>(Arrays.asList(405.0, 430.0, 405.0, 430.0)));
        CoordX.add(new ArrayList<>(Arrays.asList(470.0, 495.0, 470.0, 495.0)));
        if (player == 4) {
            CoordX.add(new ArrayList<>(Arrays.asList(0.0, 45.0, 0.0, 45.0)));
            CoordX.add(new ArrayList<>(Arrays.asList(105.0, 150.0, 105.0, 150.0)));
        }

        return CoordX;
    }

    public static List<ArrayList<Double>> getCoordY() {
        CoordY = new ArrayList<>();
        CoordY.add(new ArrayList<>(Arrays.asList(200.0, 200.0, 225.0, 225.0)));
        CoordY.add(new ArrayList<>(Arrays.asList(155.0, 155.0, 200.0, 200.0)));
        return CoordY;
    }

    public static GrayRectangle[] getFactories() {
        getCoordX();
        getCoordY();
        GrayRectangle[] factories = new GrayRectangle[CoordX.size() * 4];
        for (int i = 0; i < CoordX.size(); i++) {
            int a = i * 4;
            for (int j = 0; j < 4; j++) {
                if (i < 7) {
                    factories[a + j] = new GrayRectangle(CoordX.get(i).get(j), CoordY.get(0).get(j), 20);
                } else {
                    factories[a + j] = new GrayRectangle(CoordX.get(i).get(j), CoordY.get(1).get(j), 20);
                }
            }
        }

        return factories;

    }


}
