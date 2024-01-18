package comp1110.ass2.OurAzulGame.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @Author: Xuanchen Wang
 * This is the class to launch the application
 */
public class Start extends Application {
    @Override
    public void start(Stage stage) {
        Stage player1 = GUIPlayer.Player1.getGamePane().stage;
        Login login = new Login(player1);
        login.show();

    }
}
