package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.Containers;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.ImagePattern;

/**
 * @Author: Xuanchen Wang
 * This is the GUI center class
 */
public class GUICenter extends FlowPane {
    //The first player tile
    static Tile one;

    GUICenter(){
        setLayoutX(750.0);
        setLayoutY(50.0);
        setVgap(3.0);
        setHgap(3.0);
        setPrefSize(450.0, 90.0);
        setStyle("-fx-border-color: #fcaf17;-fx-border-width: 5;-fx-border-radius: 15");

        init();
    }


    /**
     * Initialize first player tile
     */
    private void init() {
        one = new Tile("blue");
        Image oneImg = new Image("img/one.PNG");



        one.setFill(new ImagePattern(oneImg));

        one.setGroupName(Containers.Center.getGroupName());

        getChildren().add(one);
        Containers.Center.getGroup().add(one);
    }


    public static Tile getOne() {
        return one;
    }

}
