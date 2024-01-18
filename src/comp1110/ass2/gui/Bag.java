package comp1110.ass2.gui;

import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

import java.util.Arrays;

public class Bag extends FlowPane {
    public Bag() {
        setLayoutX(750.0);
        setLayoutY(170.0);
        setPrefSize(450.0, 210.0);
        setVgap(3.0);
        setHgap(3.0);
        setAlignment(Pos.BASELINE_LEFT);
        setStyle("-fx-border-color: #fcaf17;-fx-border-width: 5;-fx-border-radius: 15");
    }

}
