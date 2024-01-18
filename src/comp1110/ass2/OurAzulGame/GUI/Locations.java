package comp1110.ass2.OurAzulGame.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Xuanchen Wang
 * This is a class store all the coordinates for each GUI components
 */
public class Locations {
    public static int player = 0;

    public static List<ArrayList<Double>> getStorageCoordX() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Collections.singletonList(380.0)));
        Output.add(new ArrayList<>(Arrays.asList(335.0, 380.0)));
        Output.add(new ArrayList<>(Arrays.asList(290.0, 335.0, 380.0)));
        Output.add(new ArrayList<>(Arrays.asList(245.0, 290.0, 335.0, 380.0)));
        Output.add(new ArrayList<>(Arrays.asList(200.0, 245.0, 290.0, 335.0, 380.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getStorageCoordY() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Collections.singletonList(295.0)));
        Output.add(new ArrayList<>(Collections.singletonList(340.0)));
        Output.add(new ArrayList<>(Collections.singletonList(385.0)));
        Output.add(new ArrayList<>(Collections.singletonList(430.0)));
        Output.add(new ArrayList<>(Collections.singletonList(475.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getMosaicCoordX() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Arrays.asList(450.0, 495.0, 540.0, 585.0, 630.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getMosaicCoordY() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Collections.singletonList(295.0)));
        Output.add(new ArrayList<>(Collections.singletonList(340.0)));
        Output.add(new ArrayList<>(Collections.singletonList(385.0)));
        Output.add(new ArrayList<>(Collections.singletonList(430.0)));
        Output.add(new ArrayList<>(Collections.singletonList(475.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getFactoryCoordX() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        if (player == 3 || player == 4) {
            Output.add(new ArrayList<>(Arrays.asList(0.0, 45.0, 0.0, 45.0)));
            Output.add(new ArrayList<>(Arrays.asList(105.0, 150.0, 105.0, 150.0)));
        }

        Output.add(new ArrayList<>(Arrays.asList(210.0, 255.0, 210.0, 255.0)));
        Output.add(new ArrayList<>(Arrays.asList(315.0, 360.0, 315.0, 360.0)));
        Output.add(new ArrayList<>(Arrays.asList(420.0, 465.0, 420.0, 465.0)));
        Output.add(new ArrayList<>(Arrays.asList(525.0, 570.0, 525.0, 570.0)));
        Output.add(new ArrayList<>(Arrays.asList(630.0, 675.0, 630.0, 675.0)));

        if (player == 4) {
            Output.add(new ArrayList<>(Arrays.asList(0.0, 45.0, 0.0, 45.0)));
            Output.add(new ArrayList<>(Arrays.asList(105.0, 150.0, 105.0, 150.0)));
        }

        return Output;
    }

    public static List<ArrayList<Double>> getFactoryCoordY() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Arrays.asList(50.0, 50.0, 95.0, 95.0)));
        Output.add(new ArrayList<>(Arrays.asList(155.0, 155.0, 200.0, 200.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getFloorCoordX() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Arrays.asList(200.0, 245.0, 290.0, 335.0, 380.0, 425.0, 470.0, 515.0, 560.0, 605.0, 650.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getFloorCoordY() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Collections.singletonList(545.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getPlacementCoordX() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Arrays.asList(315.0, 360.0, 405.0, 450.0, 495.0, 540.0, 585.0)));

        return Output;
    }

    public static List<ArrayList<Double>> getPlacementCoordY() {
        List<ArrayList<Double>> Output = new ArrayList<>();

        Output.add(new ArrayList<>(Collections.singletonList(200.0)));

        return Output;
    }
}
