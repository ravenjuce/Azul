package comp1110.ass2.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage {
    static List<ArrayList<Double>> p1CoordX;
    static List<ArrayList<Double>> p1CoordY;
    static List<ArrayList<Double>> p2CoordX;
    static List<ArrayList<Double>> p2CoordY;

    public static List<ArrayList<Double>> getP1CoordX() {
        p1CoordX = new ArrayList<>();
        p1CoordX.add(new ArrayList<>(Arrays.asList(100.0)));
        p1CoordX.add(new ArrayList<>(Arrays.asList(75.0, 100.0)));
        p1CoordX.add(new ArrayList<>(Arrays.asList(50.0, 75.0, 100.0)));
        p1CoordX.add(new ArrayList<>(Arrays.asList(25.0, 50.0, 75.0, 100.0)));
        p1CoordX.add(new ArrayList<>(Arrays.asList(0.0, 25.0, 50.0, 75.0, 100.0)));
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
    public static List<ArrayList<Double>> getP2CoordX() {
        p2CoordX = new ArrayList<>();
        p2CoordX.add(new ArrayList<>(Arrays.asList(450.0)));
        p2CoordX.add(new ArrayList<>(Arrays.asList(425.0, 450.0)));
        p2CoordX.add(new ArrayList<>(Arrays.asList(400.0, 425.0, 450.0)));
        p2CoordX.add(new ArrayList<>(Arrays.asList(375.0, 400.0, 425.0, 450.0)));
        p2CoordX.add(new ArrayList<>(Arrays.asList(350.0, 375.0, 400.0, 425.0, 450.0)));
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

    public static List<GrayRectangle> getp1Storage() {
        getP1CoordX();
        getP1CoordY();
        List<GrayRectangle> output = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                GrayRectangle r = new GrayRectangle(p1CoordX.get(i).get(j), p1CoordY.get(i).get(0), 20);
                output.add(r);
            }
        }
        return output;
    }
    public static List<GrayRectangle> getp2Storage() {
        getP2CoordX();
        getP2CoordY();
        List<GrayRectangle> output = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                GrayRectangle r = new GrayRectangle(p2CoordX.get(i).get(j), p2CoordY.get(i).get(0), 20);
                output.add(r);
            }
        }
        return output;
    }


}
