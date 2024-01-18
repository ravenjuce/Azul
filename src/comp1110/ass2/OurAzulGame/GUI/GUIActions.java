package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.Actions;
import comp1110.ass2.OurAzulGame.Containers;
import comp1110.ass2.OurAzulGame.Factory;
import comp1110.ass2.OurAzulGame.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author: Xuanchen Wang
 * This is a class including all the GUI actions like fill the factory in GUI,
 * get the storage board and so on.
 */
public class GUIActions {
    //Indicate the currentGUIPlayer
    public static GUIPlayer currentGUIPlayer;

    public static GUIPlayer firstPlayer;

    /*
     * Refill the factory, when tiles in bag is not enough, put tiles in discard to bag.
     * */
    public static void FillFactory(AnchorPane ap) {

        /*
         * Get the tile from the group and add it to factory in GUI
         * */
        for (int i = 0; i < Locations.getFactoryCoordX().size(); i++) {

            for (int j = 0; j < 4; j++) {
                //Get tile from the group
                Tile tmp = Factory.getGroup().get(i).get(j);

                /*
                 * If the number of small factory is greater than seven, the last two small factories are not in the same row with other small factories
                 * */
                if (i < 7) {
                    tmp.setLayoutX(Locations.getFactoryCoordX().get(i).get(j));
                    tmp.setLayoutY(Locations.getFactoryCoordY().get(0).get(j));

                    tmp.setOriginalX(Locations.getFactoryCoordX().get(i).get(j));
                    tmp.setOriginalY(Locations.getFactoryCoordY().get(0).get(j));

                    ap.getChildren().add(tmp);
                } else {
                    tmp.setLayoutX(Locations.getFactoryCoordX().get(i).get(j));
                    tmp.setLayoutY(Locations.getFactoryCoordY().get(1).get(j));

                    tmp.setOriginalX(Locations.getFactoryCoordX().get(i).get(j));
                    tmp.setOriginalY(Locations.getFactoryCoordY().get(1).get(j));

                    ap.getChildren().add(tmp);

                }
            }
        }


        //Repaint bag
        GamePane.b.getChildren().removeAll(GamePane.b.getChildren());
        GamePane.b.getChildren().addAll(Containers.Bag.getGroup());


        if (Containers.Discard.getGroup().size() == 0) {
            double Y = GamePane.b.getLayoutY();
            if (Containers.Bag.getGroup().size() != 0) {
                int rowNumber = Containers.Bag.getGroup().size();
                GamePane.d.setLayoutY(Y + 45 * Math.ceil(((float) rowNumber / 10)) + 20);
            }

        }


    }


    static List<GrayRectangle> getStorage() {
        //Get the coordinate of storage
        List<ArrayList<Double>> CoordX = Locations.getStorageCoordX();
        List<ArrayList<Double>> CoordY = Locations.getStorageCoordY();

        //A list to store gray rectangle
        List<GrayRectangle> output = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                GrayRectangle r = new GrayRectangle(CoordX.get(i).get(j), CoordY.get(i).get(0), 40);
                output.add(r);
            }
        }

        return output;
    }

    /**
     * A method to get mosaic board
     *
     * @param seed : A seed to randomly generate mosaic board
     * @return mosaic board
     */
    public static List<Tile> getMosaic(long seed) {
        List<Tile> output = new ArrayList<>();
        String[] colors = {"blue", "#1d953f", "#fcaf17", "#694d9f", "#ed1941"};

        //Get the coordinate of mosaic
        List<ArrayList<Double>> CoordX = Locations.getMosaicCoordX();
        List<ArrayList<Double>> CoordY = Locations.getMosaicCoordY();

        /*
         * When the seed is 0, generate the beginner mosaic board
         */
        if (seed == 0) {
            for (int i = 0; i < 5; i++) {
                int pointer = (5 - i) % 5;

                for (int j = 0; j < 5; j++) {
                    String color = colors[(pointer + j) % 5];

                    Tile tile = new Tile(color);
                    tile.setLayoutX(CoordX.get(0).get(j));
                    tile.setLayoutY(CoordY.get(i).get(0));
                    tile.setOpacity(0.4);

                    output.add(tile);
                }

            }
            return output;


        }

        /*
         * When the seed is one, generate an empty mosaic board
         */
        if (seed == 1) {
            Actions.selfConfigureModel = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Tile tile = new Tile("Gray");
                    tile.setDisable(true);
                    tile.setLayoutX(CoordX.get(0).get(j));
                    tile.setLayoutY(CoordY.get(i).get(0));

                    output.add(tile);
                }

            }
            return output;

        }

        //A list to contain five randomly generated numbers between 0 and 4(inclusive)
        List<Integer> numbers1 = new ArrayList<>();

        //A list to contain five randomly generated numbers between 1 and 4(inclusive)
        List<Integer> numbers2 = new ArrayList<>();

        Random random = new Random(seed);

        //A string to store five different colors in a random order
        String[] randomColors = new String[5];

        //Initialize numbers1
        while (numbers1.size() < 5) {
            int tmp = random.nextInt(5);
            if (!numbers1.contains(tmp)) numbers1.add(tmp);
        }

        //Initialize numbers2
        numbers2.add(0);
        while (numbers2.size() < 5) {
            int tmp = random.nextInt(4) + 1;
            if (!numbers2.contains(tmp)) numbers2.add(tmp);
        }

        //Initialize randomColors
        for (int i = 0; i < 5; i++) {
            randomColors[i] = colors[numbers1.get(i)];
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String color = randomColors[(numbers2.get(i) + j + 5) % 5];
                Tile t = new Tile(color);
                t.setLayoutX(CoordX.get(0).get(j));
                t.setLayoutY(CoordY.get(i).get(0));
                t.setOpacity(0.4);
                output.add(t);

            }
        }
        return output;

    }

    /**
     * A method to get factories area
     *
     * @return
     */
    static GrayRectangle[] getFactories() {
        //Get the coordinate of factory
        List<ArrayList<Double>> CoordX = Locations.getFactoryCoordX();
        List<ArrayList<Double>> CoordY = Locations.getFactoryCoordY();

        GrayRectangle[] factories = new GrayRectangle[CoordX.size() * 4];

        //Add gray rectangle to factories
        for (int i = 0; i < CoordX.size(); i++) {
            int a = i * 4;
            for (int j = 0; j < 4; j++) {
                if (i < 7) {
                    factories[a + j] = new GrayRectangle(CoordX.get(i).get(j), CoordY.get(0).get(j), 40);
                } else {
                    factories[a + j] = new GrayRectangle(CoordX.get(i).get(j), CoordY.get(1).get(j), 40);
                }
            }
        }

        return factories;

    }

    /**
     * A method to get floor area
     *
     * @return
     */
    static List<GrayRectangle> getFloor() {
        //Get the coordinate of factory
        List<ArrayList<Double>> CoordX = Locations.getFloorCoordX();
        List<ArrayList<Double>> CoordY = Locations.getFloorCoordY();

        List<GrayRectangle> output = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            GrayRectangle r = new GrayRectangle(CoordX.get(0).get(i), CoordY.get(0).get(0), 40);
            output.add(r);
        }

        return output;
    }

    /**
     * A method to get placement area
     *
     * @return
     */
    static List<GrayRectangle> getPlacement() {
        //Get the coordinate of placement
        List<ArrayList<Double>> CoordX = Locations.getPlacementCoordX();
        List<ArrayList<Double>> CoordY = Locations.getPlacementCoordY();

        List<GrayRectangle> output = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            GrayRectangle r = new GrayRectangle(CoordX.get(0).get(i), CoordY.get(0).get(0), 40);
            output.add(r);
        }
        return output;

    }

    /**
     * A method to change player board
     *
     * @param currentPlayer
     */
    public static void NextPlayer(GUIPlayer currentPlayer) {

        //Get two players' stage
        Stage currentStage = currentPlayer.getGamePane().stage;
        Stage nextStage = currentPlayer.getNextPlayer().getGamePane().stage;

        //Get next player's center pane
        AnchorPane center = currentGUIPlayer.getNextPlayer().getGamePane().centerPane;

        //Hide the current stage
        currentStage.hide();

        //Reset the position of discard
        double Y = GamePane.b.getLayoutY();
        if (Containers.Bag.getGroup().size() != 0) {
            int rowNumber = Containers.Bag.getGroup().size();
            GamePane.d.setLayoutY(Y + 45 * Math.ceil(((float) rowNumber / 10)) + 20);
        }

        //Update containers and factories
        center.getChildren().addAll(GamePane.containers);
        center.getChildren().addAll(GUIActions.getFactories());

        //Update score board
        currentGUIPlayer.getNextPlayer().getGamePane().bottomPane.getChildren().add(GamePane.sb);

        //Update tiles in factories
        for (int i = 0; i < Factory.getGroup().size(); i++) {
            if (Factory.getGroup().get(i).size() != 0) {
                center.getChildren().addAll(Factory.getGroup().get(i));
            }
        }

        //Show the next stage
        nextStage.show();

        //Change the player
        GUIActions.currentGUIPlayer = currentPlayer.getNextPlayer();
    }

    /**
     * Another changing player board method with different arguments
     *
     * @param currentPlayer
     * @param nextPlayer
     */
    public static void NextPlayer(GUIPlayer currentPlayer, GUIPlayer nextPlayer) {

        //Get two players' stage
        Stage currentStage = currentPlayer.getGamePane().stage;
        Stage nextStage = nextPlayer.getGamePane().stage;

        //Get next player's center pane
        AnchorPane center = nextPlayer.getGamePane().centerPane;

        //Hide the current stage
        currentStage.hide();

        //Reset the position of discard
        double Y = GamePane.b.getLayoutY();
        if (Containers.Bag.getGroup().size() != 0) {
            int rowNumber = Containers.Bag.getGroup().size();
            GamePane.d.setLayoutY(Y + 45 * Math.ceil(((float) rowNumber / 10)) + 20);
        }

        //Update containers and factories
        center.getChildren().addAll(GamePane.containers);
        center.getChildren().addAll(GUIActions.getFactories());

        //Update score board
        nextPlayer.getGamePane().bottomPane.getChildren().add(GamePane.sb);

        //Update tiles in factories
        for (int i = 0; i < Factory.getGroup().size(); i++) {
            if (Factory.getGroup().get(i).size() != 0) {
                center.getChildren().addAll(Factory.getGroup().get(i));
            }
        }

        //Show the next stage
        nextStage.show();

        //Change the player
        GUIActions.currentGUIPlayer = nextPlayer;
    }

    /**
     * When no valid place in storage, put all the tiles in placement to floor
     */
    public static void clearPlacement() {
        boolean endRound = false;

        Actions.clearPlacement();


        //If the factory and the center are all empty
        if (Containers.Center.getGroup().size() == 0) {
            int pointer = 0;
            for (int i = 0; i < Factory.getGroup().size(); i++, pointer++) {
                if (Factory.getGroup().get(i).size() != 0) break;
            }

            if (pointer == Factory.getGroup().size()) {
                if (Actions.currentPlayer.placement.getGroup().size() == 0) {
                    endRound = true;
                    Tile.releaseHandler.prepareNextRound(Locations.player, new Tile("yellow"));
                }
            }
        }
        //Repaint floor
        List<Tile> floorGroup = Actions.currentPlayer.floor.getGroup();
        for (int i = 0; i < floorGroup.size(); i++) {
            movingTileInFloor(Locations.getFloorCoordX().get(0).get(i), Locations.getFloorCoordY().get(0).get(0), floorGroup.get(i), 0, i == floorGroup.size() - 1, endRound);
        }


    }


    /**
     * Moving the tile by using animation
     */
    private static void movingTileInFloor(Double X, Double Y, Tile tile, int delay, boolean last, boolean endRound) {
        Timeline tl = new Timeline();
        KeyValue kv1 = new KeyValue(tile.layoutXProperty(), X);
        KeyValue kv2 = new KeyValue(tile.layoutYProperty(), Y);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1), actionEvent -> {
            tile.setLayoutX(X);
            tile.setLayoutY(Y);
            tile.setOriginalX(X);
            tile.setOriginalY(Y);
            if (last && !endRound) {
                changePlayer(tile);
            }
        }, kv1, kv2);
        tl.getKeyFrames().add(kf1);
        tl.setDelay(Duration.seconds(delay));
        tl.play();


    }

    /**
     * Using animation to change player board
     *
     * @param tile
     */
    private static void changePlayer(Tile tile) {
        Timeline tl = new Timeline();

        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {

            Actions.currentPlayer = Actions.currentPlayer.nextPlayer;

            //Change player board in GUI
            GUIActions.NextPlayer(GUIActions.currentGUIPlayer);

            if (Actions.currentPlayer == Player.Player2 && Actions.vsBot) {
                Actions.bot.action();
            }


        }, new KeyValue(tile.opacityProperty(), 1));

        tl.getKeyFrames().add(kf1);

        tl.play();
    }


    /**
     * Link all the players together when the player number is assigned
     *
     * @param playerNumber
     */
    static public void link(int playerNumber) {
        switch (playerNumber) {
            case 2 -> {
                GUIPlayer.Player1.setNextPlayer(GUIPlayer.Player2);
                GUIPlayer.Player2.setNextPlayer(GUIPlayer.Player1);
            }
            case 3 -> {
                GUIPlayer.Player1.setNextPlayer(GUIPlayer.Player2);
                GUIPlayer.Player2.setNextPlayer(GUIPlayer.Player3);
                GUIPlayer.Player3.setNextPlayer(GUIPlayer.Player1);
            }
            case 4 -> {
                GUIPlayer.Player1.setNextPlayer(GUIPlayer.Player2);
                GUIPlayer.Player2.setNextPlayer(GUIPlayer.Player3);
                GUIPlayer.Player3.setNextPlayer(GUIPlayer.Player4);
                GUIPlayer.Player4.setNextPlayer(GUIPlayer.Player1);
            }
        }
    }

    /**
     * A method to end the game
     */
    static public void endGame() {
        Actions.calculateBonusPoints();

        //Update each players' score
        for (int playerNumber = 0; playerNumber < Locations.player; playerNumber++) {
            currentGUIPlayer.getScore().setText(currentGUIPlayer.getGamePane().l1.getText() + " : " + Actions.currentPlayer.score);
            currentGUIPlayer = currentGUIPlayer.getNextPlayer();
            Actions.currentPlayer = Actions.currentPlayer.nextPlayer;
        }


        /*
         *Creat a new stage to display result
         */
        Stage win = new Stage();

        //Remove score board from game board
        currentGUIPlayer.getGamePane().bottomPane.getChildren().remove(GamePane.sb);

        /*
         * Redesign the title of scoreboard
         */
        GamePane.sb.setLayoutX(0);
        GamePane.sb.setLayoutY(0);

        //Get the winner information
        GamePane.sb.title.setText(Actions.findWinner());

        GamePane.sb.title.setStyle("-fx-font-size: 20");

        FlowPane bottom = new FlowPane();
        bottom.setHgap(50);


        //Add two buttons and set their actions
        Button b1 = new Button("Continue");
        Button b2 = new Button("Exit");
        b1.setOnAction(actionEvent -> {
            Actions.restart();
            restart();
            win.hide();
        });
        b2.setOnAction(actionEvent -> System.exit(0));

        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(b1, b2);

        GamePane.sb.center.setAlignment(Pos.CENTER);
        GamePane.sb.setPrefHeight(100);
        GamePane.sb.setBottom(bottom);

        Scene scene = new Scene(GamePane.sb);

        win.setScene(scene);
        win.show();

    }

    /**
     * After finishing the game, restart the game
     */
    private static void restart() {
        currentGUIPlayer.getGamePane().stage.hide();

        //Reload components
        GamePane.c = new GUICenter();
        GamePane.b = new GUIBag();
        GamePane.d = new GUIDiscard();

        GamePane.containers = new ArrayList<>(Arrays.asList(GamePane.c, GamePane.b, GamePane.d));

        //Reload each player's game pane and score label
        for (int player = 0; player < Locations.player; player++) {
            currentGUIPlayer.setGamePane(new GamePane(currentGUIPlayer.getPlayerNumber()));
            currentGUIPlayer.setScore(null);
            currentGUIPlayer = currentGUIPlayer.getNextPlayer();
        }

        Stage player1 = GUIPlayer.Player1.getGamePane().stage;
        Login login = new Login(player1);
        login.show();

    }

}
