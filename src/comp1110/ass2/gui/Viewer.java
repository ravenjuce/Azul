package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField playerTextField;
    private TextField boardTextField;


    /**
     * Draw a placement in the window, removing any previously drawn placements
     *
     * @param state an array of two strings, representing the current game state
     *              TASK 4
     */
    void displayState(String[] state) {
        // FIXME Task 4: implement the simple state viewer
        //remove previous placements
        controls.getChildren().removeAll(controls.getChildren());
        //repaint the window
        Factory.player = 2; //how many players
        controls.getChildren().addAll(Factory.getFactories());
        controls.getChildren().addAll(Storage.getp1Storage());
        controls.getChildren().addAll(Storage.getp2Storage());
        controls.getChildren().addAll(Floor.getp1Floor());
        controls.getChildren().addAll(Floor.getp2Floor());
        controls.getChildren().addAll(Mosaic.getp1Mosaic());
        controls.getChildren().addAll(Mosaic.getp2Mosaic());
        makeControls();
        repaintBoard(state);
        repaintP1(state);
        repaintP2(state);


    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label playerLabel = new Label("Player State:");
        playerTextField = new TextField();
        playerTextField.setPrefWidth(100);
        Label boardLabel = new Label("Board State:");
        boardTextField = new TextField();
        boardTextField.setPrefWidth(100);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayState(new String[]{playerTextField.getText(),
                        boardTextField.getText()});
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(playerLabel, playerTextField, boardLabel,
                boardTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(50);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    /*
    * repaint the board
    * */
    public void repaintBoard(String[] state) {
        Bag B = new Bag();
        Center C = new Center();
        Discard D = new Discard();
        controls.getChildren().addAll(B, C, D);
        //read the sharedState
        String sharedState = state[1];
        /*
         * repaint the Factory area
         * */
        Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})");
        Matcher m = p.matcher(sharedState);
        while (m.find()) {
            String g1 = m.group(1);  //the factory part
            int counter = 0;
            //repaint the factory
            for (int i = 0; i < g1.length(); i += 5) {
                for (int j = 1; j < 5; j++) {
                    Tile tmp = new Tile(g1.charAt(i + j));
                    Double X = Factory.getCoordX().get(counter).get(j - 1);
                    Double Y = Factory.getCoordY().get(0).get(j - 1);
                    tmp.setLayoutX(X);
                    tmp.setLayoutY(Y);
                    controls.getChildren().add(tmp);
                }
                counter++;

            }
        }
        /*
         * repaint the Centre area
         * */
        Pattern p1 = Pattern.compile("C([a-f]*)");
        Matcher m1 = p1.matcher(sharedState);
        while (m1.find()) {
            String g1 = m1.group(1);
            if (!g1.equals("")) {
                for (int i = 0; i < m1.end(1) - m1.start(1); i++) {
                    C.getChildren().add(new Tile(g1.charAt(i)));
                }
            }
        }
        /*
         *repaint the Bag area
         * */
        Pattern p2 = Pattern.compile("B(([0-2][0-9]){5})");
        Matcher m2 = p2.matcher(sharedState);
        String color = "abcde";
        int num = 0;
        while (m2.find()) {
            String g1 = m2.group(1);
            int counter1 = 0;
            for (int i = 0; i < g1.length(); i += 2) {
                if (g1.charAt(i) == '0') {
                    String tmp = Character.toString(g1.charAt(i + 1));
                    num = Integer.parseInt(tmp);
                } else {
                    String tmp1 = Character.toString(g1.charAt(i)) + Character.toString(g1.charAt(i + 1));
                    num = Integer.parseInt(tmp1);
                }
                for (int j = 0; j < num; j++) {
                    B.getChildren().add(new Tile(color.charAt(counter1)));
                }
                counter1++;
            }
        }
        /*
         * repaint the Discard area
         * */
        Pattern p3 = Pattern.compile("D(([0-2][0-9]){5})");
        Matcher m3 = p3.matcher(sharedState);
        int num1 = 0;
        while (m3.find()) {
            String g1 = m3.group(1);
            int counter2 = 0;
            for (int i = 0; i < g1.length(); i += 2) {
                if (g1.charAt(i) == '0') {
                    String tmp = Character.toString(g1.charAt(i + 1));
                    num1 = Integer.parseInt(tmp);
                } else {
                    String tmp1 = Character.toString(g1.charAt(i)) + Character.toString(g1.charAt(i + 1));
                    num1 = Integer.parseInt(tmp1);
                }
                for (int j = 0; j < num1; j++) {
                    D.getChildren().add(new Tile(color.charAt(counter2)));
                }
                counter2++;
            }
        }
    }

    /*
    * repaint Player1 placements
    * */
    public void repaintP1(String[] state) {

        //read player1 information from state
        String playerState = state[0];
        String player1State = null;
        Pattern p = Pattern.compile("A(\\w*)B");
        Matcher m = p.matcher(playerState);
        while (m.find()) {
            player1State = m.group(1);
        }
        /*
         * repaint the Mosaic area
         * */
        Pattern p1 = Pattern.compile("M(\\w*)S");
        Matcher m1 = p1.matcher(player1State);
        while (m1.find()) {
            String g1 = m1.group(1);
            for (int i = 0; i < g1.length(); i += 3) {
                Tile tmp = new Tile(g1.charAt(i));
                int row = Integer.parseInt(Character.toString(g1.charAt(i + 1)));
                int column = Integer.parseInt(Character.toString(g1.charAt(i + 2)));
                tmp.setLayoutY(Mosaic.getP1CoordY().get(row).get(0));
                tmp.setLayoutX(Mosaic.getp1CoordX().get(0).get(column));
                controls.getChildren().add(tmp);
            }
        }
        /*
         * repaint the Storage area
         * */
        Pattern p2 = Pattern.compile("S(\\w*)F");
        Matcher m2 = p2.matcher(player1State);
        int num = 0;
        while (m2.find()) {
            String g2 = m2.group(1);
            for (int i = 0; i < g2.length(); i += 3) {
                num = Integer.parseInt(Character.toString(g2.charAt(i + 2)));
                int row = Integer.parseInt(Character.toString(g2.charAt(i)));
                for (int j = 0; j < num; j++) {
                    Tile tmp = new Tile(g2.charAt(i + 1));
                    tmp.setLayoutY(Storage.getP1CoordY().get(row).get(0));
                    tmp.setLayoutX(Storage.getP1CoordX().get(row).get(j));
                    controls.getChildren().add(tmp);

                }
            }
        }
        /*
         * repaint the Floor area
         * */
        Pattern p3 = Pattern.compile("F(\\w*)");
        Matcher m3 = p3.matcher(player1State);
        while (m3.find()) {
            String g3 = m3.group(1);
            for (int i = 0; i < m3.end(1) - m3.start(1); i++) {
                Tile tmp = new Tile(g3.charAt(i));
                tmp.setLayoutY(Floor.getP1CoordY().get(0).get(0));
                tmp.setLayoutX(Floor.getP1CoordX().get(0).get(i));
                controls.getChildren().add(tmp);

            }
        }

    }

    /*
    * repaint player2 placements
    * */
    public void repaintP2(String[] state) {
        //read player2 information from state
        String playerState = state[0];
        String player2State = null;
        Pattern p = Pattern.compile("B(\\w*)");
        Matcher m = p.matcher(playerState);
        while (m.find()) {
            player2State = m.group(1);
        }
        /*
         * repaint the Mosaic area
         * */
        Pattern p1 = Pattern.compile("M(\\w*)S");
        Matcher m1 = p1.matcher(player2State);
        while (m1.find()) {
            String g1 = m1.group(1);
            for (int i = 0; i < g1.length(); i += 3) {
                Tile tmp = new Tile(g1.charAt(i));
                int row = Integer.parseInt(Character.toString(g1.charAt(i + 1)));
                int column = Integer.parseInt(Character.toString(g1.charAt(i + 2)));
                tmp.setLayoutY(Mosaic.getP2CoordY().get(row).get(0));
                tmp.setLayoutX(Mosaic.getp2CoordX().get(0).get(column));
                controls.getChildren().add(tmp);
            }
        }
        /*
         * repaint the Storage area
         * */
        Pattern p2 = Pattern.compile("S(\\w*)F");
        Matcher m2 = p2.matcher(player2State);
        int num = 0;
        while (m2.find()) {
            String g2 = m2.group(1);
            for (int i = 0; i < g2.length(); i += 3) {
                num = Integer.parseInt(Character.toString(g2.charAt(i + 2)));
                int row = Integer.parseInt(Character.toString(g2.charAt(i)));
                for (int j = 0; j < num; j++) {
                    Tile tmp = new Tile(g2.charAt(i + 1));
                    tmp.setLayoutY(Storage.getP2CoordY().get(row).get(0));
                    tmp.setLayoutX(Storage.getP2CoordX().get(row).get(j));
                    controls.getChildren().add(tmp);

                }
            }
        }
        /*
         * repaint the Floor area
         * */
        Pattern p3 = Pattern.compile("F(\\w*)");
        Matcher m3 = p3.matcher(player2State);
        while (m3.find()) {
            String g3 = m3.group(1);
            for (int i = 0; i < m3.end(1) - m3.start(1); i++) {
                Tile tmp = new Tile(g3.charAt(i));
                tmp.setLayoutY(Floor.getP2CoordY().get(0).get(0));
                tmp.setLayoutX(Floor.getP2CoordX().get(0).get(i));
                controls.getChildren().add(tmp);

            }
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Azul Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


