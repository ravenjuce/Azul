package comp1110.ass2.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mosaic {
    static List<ArrayList<Double>> p1CoordX;
    static List<ArrayList<Double>> p1CoordY;
    static List<ArrayList<Double>> p2CoordX;
    static List<ArrayList<Double>> p2CoordY;

    public static List<ArrayList<Double>> getp1CoordX() {
        p1CoordX = new ArrayList<>();
        p1CoordX.add(new ArrayList<>(Arrays.asList(140.0, 165.0, 190.0, 215.0, 240.0)));
        return p1CoordX;
    }

    public static List<ArrayList<Double>> getP1CoordY() {
        p1CoordY = new ArrayList<>();
        p1CoordY.add(new ArrayList<>(Arrays.asList(295.0)));
        p1CoordY.add(new ArrayList<>(Arrays.asList(320.0)));
        p1CoordY.add(new ArrayList<>(Arrays.asList(345.0)));
        p1CoordY.add(new ArrayList<>(Arrays.asList(370.0)));
        p1CoordY.add(new ArrayList<>(Arrays.asList(395.0)));
        return p1CoordY;
    }
    public static List<ArrayList<Double>> getp2CoordX() {
        p2CoordX = new ArrayList<>();
        p2CoordX.add(new ArrayList<>(Arrays.asList(490.0, 515.0, 540.0, 565.0, 590.0)));
        return p2CoordX;
    }
    public static List<ArrayList<Double>> getP2CoordY() {
        p2CoordY = new ArrayList<>();
        p2CoordY.add(new ArrayList<>(Arrays.asList(295.0)));
        p2CoordY.add(new ArrayList<>(Arrays.asList(320.0)));
        p2CoordY.add(new ArrayList<>(Arrays.asList(345.0)));
        p2CoordY.add(new ArrayList<>(Arrays.asList(370.0)));
        p2CoordY.add(new ArrayList<>(Arrays.asList(395.0)));
        return p2CoordY;
    }

    public static List<GrayRectangle> getp1Mosaic() {
        List<GrayRectangle> output = new ArrayList<>();
        getp1CoordX();
        getP1CoordY();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                GrayRectangle r = new GrayRectangle(p1CoordX.get(0).get(j), p1CoordY.get(i).get(0), 20);
                output.add(r);
            }
        }
        return output;

    }
    public static List<GrayRectangle> getp2Mosaic() {
        List<GrayRectangle> output = new ArrayList<>();
        getp2CoordX();
        getP2CoordY();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                GrayRectangle r = new GrayRectangle(p2CoordX.get(0).get(j), p2CoordY.get(i).get(0), 20);
                output.add(r);
            }
        }
        return output;

    }
}