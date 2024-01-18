package comp1110.ass2.OurAzulGame.GUI;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @Author: Xuanchen Wang
 * This class is the gray rectangle used in game pane
 */
public class GrayRectangle extends Rectangle {
    public GrayRectangle(double X, double Y, double length) {
        this.setLayoutX(X);
        this.setLayoutY(Y);
        this.setHeight(length);
        this.setWidth(length);
        this.setFill(Paint.valueOf("#6C6C6C"));
    }
}
