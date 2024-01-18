package comp1110.ass2.gui;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class GrayRectangle extends Rectangle {
    public GrayRectangle(double X, double Y, double length) {
        this.setLayoutX(X);
        this.setLayoutY(Y);
        this.setHeight(length);
        this.setWidth(length);
        this.setFill(Paint.valueOf("#6C6C6C"));
    }
}
