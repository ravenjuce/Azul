package comp1110.ass2.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Floor {
    static List<ArrayList<Double>> p1CoordX;
    static List<ArrayList<Double>> p1CoordY;
    static List<ArrayList<Double>> p2CoordX;
    static List<ArrayList<Double>> p2CoordY;

    public static List<ArrayList<Double>> getP1CoordX() {
        p1CoordX = new ArrayList<>();
        p1CoordX.add(new ArrayList<>(Arrays.asList(0.0, 25.0, 50.0, 75.0, 100.0, 125.0, 150.0)));
        return p1CoordX;
    }

    public static List<ArrayList<Double>> getP1CoordY() {
        p1CoordY = new ArrayList<>();
        p1CoordY.add(new ArrayList<>(Arrays.asList(435.0)));
        return p1CoordY;
    }

    public static List<ArrayList<Double>> getP2CoordX() {
        p2CoordX = new ArrayList<>();
        p2CoordX.add(new ArrayList<>(Arrays.asList(350.0, 375.0, 400.0, 425.0, 450.0, 475.0, 500.0)));
        return p2CoordX;
    }

    public static List<ArrayList<Double>> getP2CoordY() {
        p2CoordY = new ArrayList<>();
        p2CoordY.add(new ArrayList<>(Arrays.asList(435.0)));
        return p2CoordY;
    }

    public static List<GrayRectangle> getp1Floor() {
        getP1CoordX();
        getP1CoordY();
        List<GrayRectangle> output = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            GrayRectangle r = new GrayRectangle(p1CoordX.get(0).get(i), p1CoordY.get(0).get(0), 20);
            output.add(r);
        }
        return output;

    }

    public static List<GrayRectangle> getp2Floor() {
        getP2CoordX();
        getP2CoordY();
        List<GrayRectangle> output = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            GrayRectangle r = new GrayRectangle(p2CoordX.get(0).get(i), p2CoordY.get(0).get(0), 20);
            output.add(r);
        }
        return output;

    }

}
