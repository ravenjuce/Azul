package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.Actions;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xuanchen Wang
 * This class is the game pane.It includes all the GUI components used in the project
 */
public class GamePane {

    //These components are shared by all players
    public static GUICenter c = new GUICenter();
    public static GUIBag b = new GUIBag();
    public static GUIDiscard d = new GUIDiscard();

    //The score board can not be initialized until the player number is determined
    public static ScoreBoard sb;

    //A list to contain all the static containers
    public static List<Node> containers = new ArrayList<>(Arrays.asList(c, b, d));

    public BorderPane root;
    public AnchorPane centerPane, bottomPane;
    Scene scene;
    Stage stage;

    // Components in centerPane
    Button b1;
    public Button b2;
    public Label l1;

    GamePane(int player) {
        root = new BorderPane();
        centerPane = new AnchorPane();
        bottomPane = new AnchorPane();

        Label c1 = new Label("Please click the color you want to choose");
        c1.setLayoutX(450.0);
        c1.setLayoutY(10.0);
        c1.setStyle("-fx-font-size: 20");

        Label c2 = new Label("Please click \'NextPlayer\' button when there is no valid place in storage");
        c2.setLayoutX(220.0);
        c2.setLayoutY(170.0);
        c2.setStyle("-fx-font-size: 15");

        b1 = new Button("Start");
        b1.setLayoutX(70.0);
        b1.setLayoutY(50.0);
        b1.setDisable(true);

        //The function of b1 is to fill the factory
        b1.setOnAction(actionEvent -> {
            Actions.FillFactory();
            GUIActions.FillFactory(centerPane);
            b1.setDisable(true);
        });

        b2 = new Button("NextPlayer");
        b2.setLayoutX(150.0);
        b2.setLayoutY(50.0);

        l1 = new Label("Player" + player);
        l1.setLayoutX(550.0);
        l1.setLayoutY(30.0);
        l1.setStyle("-fx-font-size: 40;-fx-text-fill: #ef4136");

        //Initialize centerPane
        centerPane.getChildren().addAll(GUIActions.getStorage());
        centerPane.getChildren().addAll(GUIActions.getFloor());
        centerPane.getChildren().addAll(GUIActions.getPlacement());
        centerPane.getChildren().addAll(c1, c2);

        //Initialize bottomPane
        bottomPane.getChildren().addAll(b1, b2, l1);
        bottomPane.setPrefHeight(100.0);

        //Initialize root
        root.setCenter(centerPane);
        root.setBottom(bottomPane);

        //Initialize stage
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setWidth(1280);
        stage.setHeight(768);
    }
}
