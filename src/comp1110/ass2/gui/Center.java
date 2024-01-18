package comp1110.ass2.gui;

import javafx.scene.layout.FlowPane;

public class Center extends FlowPane {
    public Center(){
        setLayoutX(750.0);
        setLayoutY(50.0);
        setVgap(3.0);
        setHgap(3.0);
        setPrefSize(450.0, 90.0);
        setStyle("-fx-border-color: #fcaf17;-fx-border-width: 5;-fx-border-radius: 15");
    }

}
