package comp1110.ass2.OurAzulGame.GUI;

import comp1110.ass2.OurAzulGame.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuanchen Wang
 * This is the tile class. The tile is a rectangle with color,
 * group(indicate where the tile belongs to) and some other important
 * properties.Each tile is equipped by different kinds of event handler
 * like drag handler, click handler and release handler
 */
public class Tile extends Rectangle {
    String color;
    String GroupName;
    List<Tile> group;
    Double originalX;
    Double originalY;
    int botUsedRow;
    int botUsedColumn;


    public Tile(String color) {
        //Set basic properties of tile
        this.color = color;
        setWidth(40);
        setHeight(40);
        setFill(Paint.valueOf(color));

        //Set event on tile
        setEventHandler(MouseEvent.MOUSE_DRAGGED, new Draghandler(this));
        setEventHandler(MouseEvent.MOUSE_RELEASED, new releaseHandler(this));
        setEventHandler(MouseEvent.MOUSE_CLICKED, new ClickedHandler(this));
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public List<Tile> getGroup() {
        return group;
    }

    public void setGroup(List<Tile> group) {
        this.group = group;
    }

    public Double getOriginalX() {
        return originalX;
    }

    public void setOriginalX(Double originalX) {
        this.originalX = originalX;
    }

    public Double getOriginalY() {
        return originalY;
    }

    public void setOriginalY(Double originalY) {
        this.originalY = originalY;
    }

    public int getBotUsedRow() {
        return botUsedRow;
    }

    public void setBotUsedRow(int botUsedRow) {
        this.botUsedRow = botUsedRow;
    }

    public int getBotUsedColumn() {
        return botUsedColumn;
    }

    public void setBotUsedColumn(int botUsedColumn) {
        this.botUsedColumn = botUsedColumn;
    }

    /**
     * A class to implement the event handler to achieve the functionality of dragging
     */
    static class Draghandler implements EventHandler<MouseEvent> {
        Tile tile;
        double pressedX;
        double pressedY;

        public Draghandler(Tile tile) {
            this.tile = tile;
        }

        @Override
        public void handle(MouseEvent Event) {
            //Add a mouse pressed handler to get the coordinate when pressing the mpouse
            tile.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
                this.pressedX = event.getX();
                this.pressedY = event.getY();
            });

            double freshedX = Event.getX() - pressedX + tile.getLayoutX();
            double freshedY = Event.getY() - pressedY + tile.getLayoutY();

            tile.setLayoutX(freshedX);
            tile.setLayoutY(freshedY);

        }
    }

    /**
     * A class to handle things when the mouse is released.
     */
    static class releaseHandler implements EventHandler<MouseEvent> {
        Tile tile;
        DragResult storageResult;
        DragResult mosaicResult;

        public releaseHandler(Tile tile) {
            this.tile = tile;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            storageResult = Actions.DragAvailableInStorage(tile);
            mosaicResult = Actions.DragAvailableInMosaic(tile);


            /*
             If the moving place is valid in storage
             */
            if (storageResult.getFlag()) {
                Drag(storageResult.getCoordX(), storageResult.getCoordY(), storageResult.getRow() == 0);

                //Repaint floor
                List<Tile> floorGroup = Actions.currentPlayer.floor.getGroup();

                if (floorGroup.contains(GUICenter.getOne())) {
                    GUIActions.firstPlayer = GUIActions.currentGUIPlayer;
                }
                for (int i = 0; i < floorGroup.size(); i++) {
                    movingTile(Locations.getFloorCoordX().get(0).get(i), Locations.getFloorCoordY().get(0).get(0), floorGroup.get(i), 0, false);
                }

                //If the factory and the center are all empty
                if (Containers.Center.getGroup().size() == 0) {
                    int pointer = 0;
                    for (int i = 0; i < Factory.getGroup().size(); i++, pointer++) {
                        if (Factory.getGroup().get(i).size() != 0) break;
                    }

                    if (pointer == Factory.getGroup().size()) {
                        if (Actions.currentPlayer.placement.getGroup().size() == 0) {
                            if (!Actions.selfConfigureModel) {
                                prepareNextRound(Locations.player, tile);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                }

                //If it is time to change player
                if (storageResult.isNextPlayer()) {
                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(true);
                    //Change player
                    changePlayer();

                    return;
                }

                //If the placement is empty, change player
                if (Actions.currentPlayer.placement.getGroup().size() == 0) {
                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(true);
                    changePlayer();
                }

                return;
            }

            /**
             * If the tile is drag to mosaic
             */
            if (mosaicResult.getFlag()) {
                Drag(mosaicResult.getCoordX(), mosaicResult.getCoordY(), false);

                //Repaint discard
                GamePane.d.getChildren().removeAll(GamePane.d.getChildren());
                GamePane.d.getChildren().addAll(Containers.Discard.getGroup());

                //Calculate points
                Actions.currentPlayer.score += Actions.calculatePoints(mosaicResult.getRow(), mosaicResult.getColumnInMosaic());

                Actions.currentPlayer.rightMost.set(mosaicResult.getRow(), null);

                //Make a judgement that if all the valid tiles are moved to mosaic, if it is ,change player
                for (int i = 0; i < 5; i++) {
                    if (Actions.currentPlayer.rightMost.get(i) != null) {
                        break;
                    }
                    if (i == 4) {

                        Actions.selfConfigureModelArg++;
                        GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(true);
                        prepareNextRoundSelfModel(Actions.selfConfigureModelArg, tile);

                        return;

                    }
                }


            }

            //If the given coordinate is illegal,move the tile to original place
            tile.setLayoutX(tile.getOriginalX());
            tile.setLayoutY(tile.getOriginalY());


        }

        /**
         * Use animation to change player
         */
        private void changePlayer() {
            Timeline tl = new Timeline();

            KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {
                GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

                Actions.currentPlayer = Actions.currentPlayer.nextPlayer;

                //Change player board in GUI
                GUIActions.NextPlayer(GUIActions.currentGUIPlayer);

                if (Actions.vsBot) {
                    Actions.bot.action();
                }
            }, new KeyValue(tile.opacityProperty(), 1));

            tl.getKeyFrames().add(kf1);

            tl.play();
        }


        /**
         * Moving the tile by using animation
         */
        private static void movingTile(Double X, Double Y, Tile tile, int delay, boolean last) {
            Timeline tl = new Timeline();
            KeyValue kv1 = new KeyValue(tile.layoutXProperty(), X);
            KeyValue kv2 = new KeyValue(tile.layoutYProperty(), Y);

            KeyFrame kf1 = new KeyFrame(Duration.seconds(1), actionEvent -> {
                tile.setLayoutX(X);
                tile.setLayoutY(Y);
                tile.setOriginalX(X);
                tile.setOriginalY(Y);

                if (last) {
                    //Calculate penalty points
                    Actions.penalty();

                    //Update player's score
                    GUIActions.currentGUIPlayer.getScore().setText(GUIActions.currentGUIPlayer.getGamePane().l1.getText() + " : " + Actions.currentPlayer.score);

                    //Clear floor
                    Actions.clearFloor();

                    //Move the first player tile to center
                    if (GamePane.c.getChildren().size() == 0) {
                        GamePane.c.getChildren().addAll(Containers.Center.getGroup());
                    }

                    //Repaint discard
                    GamePane.d.getChildren().removeAll(GamePane.d.getChildren());
                    GamePane.d.getChildren().addAll(Containers.Discard.getGroup());
                }
            }, kv1, kv2);
            tl.getKeyFrames().add(kf1);
            tl.setDelay(Duration.seconds(delay));
            tl.play();


        }

        /**
         * Drag the tile(without using animation)
         */
        private void Drag(Double X, Double Y, boolean isFirstRow) {
            tile.setLayoutX(X);
            tile.setLayoutY(Y);

            if (!isFirstRow) {
                tile.setOriginalX(X);
                tile.setOriginalY(Y);
            }
        }

        /**
         * If factories and center are all empty, moving tiles to mosaic
         * @param pointer
         * @param tile
         */
        public static void prepareNextRound(int pointer, Tile tile) {
            //A list to indicate which row is full
            List<Integer> indexes = new ArrayList();

            //Find the row that is full
            for (int i = 0; i < 5; i++) {
                if (Actions.currentPlayer.rightMost.get(i) != null) {
                    indexes.add(Actions.currentPlayer.rightMost.get(i));
                    Actions.currentPlayer.rightMost.set(i, null);
                }
            }

            //Move the rightmost tile to mosaic
            for (int i = 0; i < indexes.size(); i++) {
                int index = indexes.get(i);
                Tile tmp = Actions.currentPlayer.storage.getGroup().get(index).get(0);
                Actions.movingToMosaic(index);
                movingTile(tmp.getOriginalX(), tmp.getOriginalY(), tmp, i, i == indexes.size() - 1);

            }

            //Using animation to change player
            Timeline tl = new Timeline();
            KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {
                //After the last player finishing moving tiles to mosaic
                if (pointer == 1) {
                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

                    //If the game is over
                    if (Actions.isEndOfGame()) {
                        GUIActions.endGame();
                        return;
                    }

                    //If the current player is not the first player, change player to the first player
                    if (Actions.currentPlayer != Actions.firstPlayer) {
                        GUIActions.NextPlayer(GUIActions.currentGUIPlayer, GUIActions.firstPlayer);
                        Actions.currentPlayer = Actions.firstPlayer;
                    }

                    //Refill factory
                    Actions.FillFactory();
                    GUIActions.FillFactory(GUIActions.currentGUIPlayer.getGamePane().centerPane);

                    //If player is versus bot, automatically generate actions
                    if (Actions.currentPlayer == Player.Player2 && Actions.vsBot) {
                        Actions.bot.action();
                    }


                } else {
                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

                    //Change player
                    Actions.currentPlayer = Actions.currentPlayer.nextPlayer;

                    //Change player board in GUI
                    GUIActions.NextPlayer(GUIActions.currentGUIPlayer);

                    prepareNextRound(pointer - 1, tile);
                }

            }, new KeyValue(tile.opacityProperty(), 1));
            tl.getKeyFrames().add(kf1);

            tl.setDelay(Duration.seconds(indexes.size()));
            tl.play();


        }

        /**
         * If factory and center are all empty, move tiles to mosaic(mosaic board is empty)
         * @param pointer
         * @param tile
         */
        public static void prepareNextRoundSelfModel(int pointer, Tile tile) {
            Timeline tl = new Timeline();
            KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {
                if (pointer == Locations.player) {
                    Actions.penalty();

                    //Update player's score
                    GUIActions.currentGUIPlayer.getScore().setText(GUIActions.currentGUIPlayer.getGamePane().l1.getText() + " : " + Actions.currentPlayer.score);

                    Actions.clearFloor();

                    //Repaint discard
                    GamePane.d.getChildren().removeAll(GamePane.d.getChildren());
                    GamePane.d.getChildren().addAll(Containers.Discard.getGroup());

                    //Repaint center
                    GamePane.c.getChildren().removeAll(GamePane.c.getChildren());
                    GamePane.c.getChildren().addAll(Containers.Center.getGroup());

                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

                    //If the game is over
                    if (Actions.isEndOfGame()) {
                        GUIActions.endGame();
                        return;
                    }

                    if (Actions.currentPlayer != Actions.firstPlayer) {
                        GUIActions.NextPlayer(GUIActions.currentGUIPlayer, GUIActions.firstPlayer);
                        Actions.currentPlayer = Actions.firstPlayer;
                    }


                    Actions.FillFactory();
                    GUIActions.FillFactory(GUIActions.currentGUIPlayer.getGamePane().centerPane);

                    Actions.selfConfigureModelArg = 0;

                    if (Actions.currentPlayer == Player.Player2 && Actions.vsBot) {
                        Actions.bot.action();
                    }


                } else {
                    Actions.penalty();

                    //Update player's score
                    GUIActions.currentGUIPlayer.getScore().setText(GUIActions.currentGUIPlayer.getGamePane().l1.getText() + " : " + Actions.currentPlayer.score);

                    Actions.clearFloor();

                    //Repaint discard
                    GamePane.d.getChildren().removeAll(GamePane.d.getChildren());
                    GamePane.d.getChildren().addAll(Containers.Discard.getGroup());

                    //Repaint center
                    GamePane.c.getChildren().removeAll(GamePane.c.getChildren());
                    GamePane.c.getChildren().addAll(Containers.Center.getGroup());


                    GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

                    Actions.currentPlayer = Actions.currentPlayer.nextPlayer;
                    //Change player board in GUI
                    GUIActions.NextPlayer(GUIActions.currentGUIPlayer);
                }

            }, new KeyValue(tile.opacityProperty(), 1));
            tl.getKeyFrames().add(kf1);

            tl.setDelay(Duration.seconds(0));
            tl.play();


        }
    }

    /**
     * A class to handle mouse click things
     */
    static class ClickedHandler implements EventHandler<MouseEvent> {
        Tile tile;

        public ClickedHandler(Tile tile) {
            this.tile = tile;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            /*
             *Click in factory
             * */
            if (Factory.getGroupName().contains(tile.getGroupName())) {
                Actions.clickInFactory(tile);

                //Two lists to store the tile where it belongs to
                List<Tile> placement = Actions.currentPlayer.placement.getGroup();
                List<Tile> center = Containers.Center.getGroup();


                for (int i = 0; i < placement.size(); i++) {
                    Tile tmp = placement.get(i);
                    Double newX = Locations.getPlacementCoordX().get(0).get(i);
                    Double newY = Locations.getPlacementCoordY().get(0).get(0);

                    //Add the tile to placement in GUI
                    tmp.setLayoutX(newX);
                    tmp.setLayoutY(newY);
                    tmp.setOriginalX(newX);
                    tmp.setOriginalY(newY);
                }

                //Clear the center
                GUICenter fp = GamePane.c;
                fp.getChildren().removeAll(fp.getChildren());

                for (Tile tmp : center) {
                    //Add the tile to center in GUI
                    fp.getChildren().add(tmp);

                    tmp.setOriginalX(0.0);
                    tmp.setOriginalY(0.0);
                }
            }

            /*
             * Click in center
             * */
            if (tile.getGroupName().equals(Containers.Center.getGroupName())) {
                if (tile == GUICenter.getOne()) return;
                Actions.clickInCenter(tile);

                List<Tile> placement = Actions.currentPlayer.placement.getGroup();

                //Record the first player
                if (placement.contains(GUICenter.getOne())) {
                    GUIActions.firstPlayer = GUIActions.currentGUIPlayer;
                }

                //Add tiles to placement in GUI
                for (int i = 0; i < placement.size(); i++) {
                    Tile tmp1 = placement.get(i);
                    Double newX = Locations.getPlacementCoordX().get(0).get(i);
                    Double newY = Locations.getPlacementCoordY().get(0).get(0);

                    tmp1.setLayoutX(newX);
                    tmp1.setLayoutY(newY);
                    tmp1.setOriginalX(newX);
                    tmp1.setOriginalY(newY);

                    GUIActions.currentGUIPlayer.getGamePane().centerPane.getChildren().add(tmp1);


                }

            }
        }

    }

}
