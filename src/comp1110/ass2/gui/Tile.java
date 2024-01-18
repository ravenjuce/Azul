package comp1110.ass2.gui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    char color; // or char? // "a" - "f"

    public Tile(char color) {
        this.color = color;
        String realColor = null;
        Image one = new Image("img/one.PNG");

        switch (color) {
            case 'a' -> realColor = "BLUE";
            case 'b' -> realColor = "GREEN";
            case 'c' -> realColor = "ORANGE";
            case 'd' -> realColor = "PURPLE";
            case 'e' -> realColor = "RED";
            case 'f' -> setFill(new ImagePattern(one));
        }
        setWidth(20);
        setHeight(20);
        if (realColor != null) {
            setFill(Paint.valueOf(realColor));
        }

    }

}
