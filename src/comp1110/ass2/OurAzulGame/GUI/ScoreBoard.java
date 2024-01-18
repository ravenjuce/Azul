package comp1110.ass2.OurAzulGame.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 * A score board class
 * @Author: Xuanchen Wang
 */
public class ScoreBoard extends BorderPane {
    Label player1Score;
    Label player2Score;
    Label player3Score;
    Label player4Score;
    Label title;

    FlowPane center;
    FlowPane top;

    public ScoreBoard(int playerNumber) {
        setPrefSize(400.0, 50.0);
        setLayoutX(800.0);
        setLayoutY(30.0);

        top =new FlowPane();
        top.setAlignment(Pos.TOP_CENTER);

        center = new FlowPane();
        center.setHgap(30);
        center.setAlignment(Pos.BOTTOM_CENTER);

        title = new Label("Score Board");
        title.setStyle("-fx-font-size: 20");
        top.getChildren().add(title);


        switch (playerNumber) {
            case 2 -> {
                player1Score = GUIPlayer.Player1.getScore();
                player2Score = GUIPlayer.Player2.getScore();

                center.getChildren().addAll(player1Score,player2Score);

                setTop(top);
                setCenter(center);

            }
            case 3 ->{
                player1Score = GUIPlayer.Player1.getScore();
                player2Score = GUIPlayer.Player2.getScore();
                player3Score = GUIPlayer.Player3.getScore();

                center.getChildren().addAll(player1Score,player2Score,player3Score);

                setTop(top);
                setCenter(center);
            }
            case 4 ->{
                player1Score = GUIPlayer.Player1.getScore();
                player2Score = GUIPlayer.Player2.getScore();
                player3Score = GUIPlayer.Player3.getScore();
                player4Score = GUIPlayer.Player4.getScore();

                center.getChildren().addAll(player1Score,player2Score,player3Score,player4Score);

                setTop(top);
                setCenter(center);
            }
        }
    }
}
