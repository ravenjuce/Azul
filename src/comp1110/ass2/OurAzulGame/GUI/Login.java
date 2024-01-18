package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * @Author: Xuanchen Wang
 * This class is a login panel.It allows users to select the number of players and
 * set the random seed for each player's mosaic board.
 * This class will set the functions of some buttons in game panes depending on the
 * number of players selected by user.
 */
public class Login extends Stage {
    GamePane p1Pane = GUIPlayer.Player1.getGamePane();
    GamePane p2Pane = GUIPlayer.Player2.getGamePane();
    GamePane p3Pane = GUIPlayer.Player3.getGamePane();
    GamePane p4Pane = GUIPlayer.Player4.getGamePane();

    Login(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setSpacing(25.0);
        root.setStyle("-fx-background-color: #FFFAF4");

        Label l1 = new Label("Azul");
        l1.setTextFill(Paint.valueOf("green"));
        l1.setStyle("-fx-font-size: 50");

        Label l2 = new Label("Player");
        l2.setStyle("-fx-font-size: 20");

        Label l3 = new Label("Welcome!");
        l3.setStyle("-fx-font-size: 40");

        Button b1 = new Button("ONE");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Set Mosaic");

        b1.setPrefWidth(80);
        b2.setPrefWidth(80);
        b3.setPrefWidth(80);
        b4.setPrefWidth(80);
        b5.setPrefWidth(80);

        b1.setOnAction(event -> {
            //Hide the login window
            this.hide();

            Locations.player = 2;
            Actions.vsBot = true;

            //Link all the players together
            GUIActions.link(2);
            Actions.link(2);

            //Initialize score board and factories in GamePane by the player number, add bag,center and discard
            GamePane.sb = new ScoreBoard(2);
            p1Pane.bottomPane.getChildren().add(GamePane.sb);
            p1Pane.centerPane.getChildren().addAll(GUIActions.getFactories());
            p1Pane.centerPane.getChildren().addAll(GamePane.containers);

            //Set event handler for the NextPlayer button
            p1Pane.b2.setOnAction(event1 -> GUIActions.clearPlacement());

            p2Pane.b2.setOnAction(event2 -> GUIActions.clearPlacement());

            GUIPlayer.Player1.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player1.getSeed()));
            GUIPlayer.Player2.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player2.getSeed()));

            GUIPlayer.Player1.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player1.getMosaicBoard());
            GUIPlayer.Player2.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player2.getMosaicBoard());

            Actions.currentPlayer = Player.Player1;
            GUIActions.currentGUIPlayer = GUIPlayer.Player1;

            GUIPlayer.Player1.getGamePane().b1.setDisable(false);


            stage.show();


        });

        /*
         * Set event handler to buttons in login window
         * */
        b2.setOnAction(event -> {
            //Hide the login window
            this.hide();

            Locations.player = 2;

            //Link all the players together
            GUIActions.link(2);
            Actions.link(2);

            //Initialize score board and factories in GamePane by the player number, add bag,center and discard
            GamePane.sb = new ScoreBoard(2);
            p1Pane.bottomPane.getChildren().add(GamePane.sb);
            p1Pane.centerPane.getChildren().addAll(GUIActions.getFactories());
            p1Pane.centerPane.getChildren().addAll(GamePane.containers);

            //Set event handler for the NextPlayer button
            p1Pane.b2.setOnAction(event1 -> GUIActions.clearPlacement());
            p2Pane.b2.setOnAction(event2 -> GUIActions.clearPlacement());

            GUIPlayer.Player1.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player1.getSeed()));
            GUIPlayer.Player2.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player2.getSeed()));

            GUIPlayer.Player1.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player1.getMosaicBoard());
            GUIPlayer.Player2.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player2.getMosaicBoard());

            Actions.currentPlayer = Player.Player1;
            GUIActions.currentGUIPlayer = GUIPlayer.Player1;

            GUIPlayer.Player1.getGamePane().b1.setDisable(false);


            stage.show();


        });
        b3.setOnAction(event -> {
            //Hide the login window
            this.hide();

            Locations.player = 3;
            GUIActions.link(3);
            Actions.link(3);

            GamePane.sb = new ScoreBoard(3);
            p1Pane.bottomPane.getChildren().add(GamePane.sb);
            p1Pane.centerPane.getChildren().addAll(GUIActions.getFactories());
            p1Pane.centerPane.getChildren().addAll(GamePane.containers);

            //Set event handler for the NextPlayer button
            p1Pane.b2.setOnAction(event1 -> GUIActions.clearPlacement());

            p2Pane.b2.setOnAction(event2 -> GUIActions.clearPlacement());

            p3Pane.b2.setOnAction(event3 -> GUIActions.clearPlacement());


            GUIPlayer.Player1.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player1.getSeed()));
            GUIPlayer.Player2.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player2.getSeed()));
            GUIPlayer.Player3.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player3.getSeed()));

            GUIPlayer.Player1.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player1.getMosaicBoard());
            GUIPlayer.Player2.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player2.getMosaicBoard());
            GUIPlayer.Player3.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player3.getMosaicBoard());


            Actions.currentPlayer = Player.Player1;
            GUIActions.currentGUIPlayer = GUIPlayer.Player1;

            GUIPlayer.Player1.getGamePane().b1.setDisable(false);

            stage.show();

        });
        b4.setOnAction(event -> {
            //Hide the login window
            this.hide();

            Locations.player = 4;
            GUIActions.link(4);
            Actions.link(4);

            GamePane.sb = new ScoreBoard(4);
            p1Pane.bottomPane.getChildren().add(GamePane.sb);
            p1Pane.centerPane.getChildren().addAll(GUIActions.getFactories());
            p1Pane.centerPane.getChildren().addAll(GamePane.containers);

            //Set event handler for the NextPlayer button
            p1Pane.b2.setOnAction(event1 -> GUIActions.clearPlacement());

            p2Pane.b2.setOnAction(event2 -> GUIActions.clearPlacement());

            p3Pane.b2.setOnAction(event3 -> GUIActions.clearPlacement());

            p4Pane.b2.setOnAction(event4 -> GUIActions.clearPlacement());

            GUIPlayer.Player1.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player1.getSeed()));
            GUIPlayer.Player2.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player2.getSeed()));
            GUIPlayer.Player3.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player3.getSeed()));
            GUIPlayer.Player4.setMosaicBoard(GUIActions.getMosaic(GUIPlayer.Player4.getSeed()));

            GUIPlayer.Player1.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player1.getMosaicBoard());
            GUIPlayer.Player2.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player2.getMosaicBoard());
            GUIPlayer.Player3.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player3.getMosaicBoard());
            GUIPlayer.Player4.getGamePane().centerPane.getChildren().addAll(GUIPlayer.Player4.getMosaicBoard());

            Actions.currentPlayer = Player.Player1;
            GUIActions.currentGUIPlayer = GUIPlayer.Player1;

            GUIPlayer.Player1.getGamePane().b1.setDisable(false);

            stage.show();

        });

        b5.setOnAction(event5 -> {
            /*
             Create a new stage to achieve the functionality of setting mosaic random seed
             */
            Stage st = new Stage();
            BorderPane root3 = new BorderPane();
            FlowPane center = new FlowPane();
            FlowPane north = new FlowPane();
            FlowPane south = new FlowPane();

            center.setAlignment(Pos.BASELINE_CENTER);
            center.setVgap(20);
            center.setHgap(20);

            north.setAlignment(Pos.CENTER);
            north.setPrefHeight(100);

            south.setAlignment(Pos.CENTER);
            south.setPrefHeight(100);
            south.setHgap(80);

            Label lb1 = new Label("Player1");
            Label lb2 = new Label("Player2");
            Label lb3 = new Label("Player3");
            Label lb4 = new Label("Player4");

            TextField player1 = new TextField("0");
            TextField player2 = new TextField("0");
            TextField player3 = new TextField("0");
            TextField player4 = new TextField("0");

            player1.setPrefWidth(100.0);
            player2.setPrefWidth(100.0);
            player3.setPrefWidth(100.0);
            player4.setPrefWidth(100.0);

            Label lbn1 = new Label("Please set random seeds(Seed 1 represents an empty board)");
            lbn1.setStyle("-fx-font-size: 13");

            Button bs1 = new Button("Apply");
            Button bs2 = new Button("Cancel");

            //Change the random seed for each player
            bs1.setOnAction(event6 -> {
                GUIPlayer.Player1.setSeed(Long.parseUnsignedLong(player1.getText()));
                GUIPlayer.Player2.setSeed(Long.parseUnsignedLong(player2.getText()));
                GUIPlayer.Player3.setSeed(Long.parseUnsignedLong(player3.getText()));
                GUIPlayer.Player4.setSeed(Long.parseUnsignedLong(player4.getText()));
                st.hide();
            });
            bs2.setOnAction(event7 -> st.hide());


            center.getChildren().addAll(lb1, player1, lb2, player2, lb3, player3, lb4, player4);
            north.getChildren().add(lbn1);
            south.getChildren().addAll(bs1, bs2);

            root3.setTop(north);
            root3.setCenter(center);
            root3.setBottom(south);

            Scene scene = new Scene(root3, 400, 300);
            st.setScene(scene);
            st.show();


        });

        root.getChildren().addAll(l3, l1, l2, b1, b2, b3, b4, b5);
        Scene scene = new Scene(root, 200, 480);
        setTitle("Start");
        setScene(scene);

    }

}
