package comp1110.ass2.OurAzulGame.GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

/**
 * @Author: Xuanchen Wang
 * This is the GUI discard class
 */
public class GUIDiscard extends FlowPane {
    GUIDiscard(){
        setLayoutX(750.0);
        setLayoutY(550.0);
        setVgap(3.0);
        setHgap(3.0);
        setPrefSize(450.0, 100.0);
        setAlignment(Pos.TOP_LEFT);
        setStyle("-fx-border-color: #fcaf17;-fx-border-width: 5;-fx-border-radius: 15");
    }
}
