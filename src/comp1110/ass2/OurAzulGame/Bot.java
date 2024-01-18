package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.*;

/**
 * A bot to versus player
 * @Author: Xuanchen Wang
 */
public class Bot {

    /**
     * Automatically generate actions like click tile and drag tile
     */
    public void action() {
        //Get the tile that can be move to storage
        Tile tile = selectTile();

        //If all the tiles in factory and center can not be move to storage, select a tile from factory or center
        if (tile == null) {
            Random r = new Random();
            List<ArrayList<Tile>> factory = Factory.getGroup();

            for (ArrayList<Tile> tmp : factory) {
                if (tmp.size() != 0) {
                    tile = tmp.get(r.nextInt(4));
                    break;
                }
            }

            //If the factory is empty, select a tile from center
            if (tile == null) {
                List<Tile> center = Containers.Center.getGroup();
                tile = center.get(r.nextInt(center.size()));

                click(tile);

                //Move the tile to floor
                GUIActions.clearPlacement();
                return;

            }


        }

        //Click the tile
        click(tile);

        List<Tile> placement = new ArrayList<>(Actions.currentPlayer.placement.getGroup());

        int index = tile.getBotUsedColumn();

        //Move all the tiles in placement to storage
        for (int i = 0; i < placement.size(); i++, index--) {
            if (index < 0) {
                break;
            }
            if (placement.get(i) == GUICenter.getOne()) {
                index++;
                continue;
            }
            double originalX = placement.get(i).getLayoutX();
            double originalY = placement.get(i).getLayoutY();
            placement.get(i).setLayoutX(Locations.getStorageCoordX().get(tile.getBotUsedRow()).get(index));
            placement.get(i).setLayoutY(Locations.getStorageCoordY().get(tile.getBotUsedRow()).get(0));
            moveTOStorage(placement.get(i), originalX, originalY);


        }


    }

    /**
     * Select a tile that cen be move to storage
     * @return : Valid tile
     */
    private Tile selectTile() {
        //A list to store all the valid tiles
        List<Tile> validTiles = new ArrayList<>();

        //Find a tile without penalty(no need to move tile to floor)
        findTiles(0, validTiles);

        //If there is no valid tile without penalty, get the tile with penalty(At least four tiles needed to move to floor)
        if (validTiles.size() == 0) {
            findTiles(4, validTiles);
        }

        //If there is no valid tile
        if (validTiles.size() == 0) {
            return null;
        } else {
            Random r = new Random();
            return validTiles.get(r.nextInt(validTiles.size()));
        }

    }

    /**
     * Find valid tiles
     * @param pointer : Indicate the end of moving mosaic
     * @param validTile: A list to store all the valid tiles
     */
    private void findTiles(int pointer, List<Tile> validTile) {
        //Get valid positions and valid colors
        Map<Integer, String> table = selectPosition();
        List<Integer> tileNumbers = new ArrayList<>();

        for (Integer tmp : table.keySet()) {
            int tileNumber = tmp % 10 + pointer;
            tileNumbers.add(tileNumber);
            if (tileNumber <= 0) {
                continue;
            }

            //Get all the valid colors
            List<String> colors = new ArrayList<>(Arrays.asList(table.get(tmp).split(",")));


            List<ArrayList<Tile>> factory = Factory.getGroup();
            for (int i = 0; i < 5; i++) {
                Map<String, Integer> colorToNumber = new HashMap<>();
                Map<String, Tile> colorToTile = new HashMap<>();

                for (String color : colors) {
                    colorToNumber.put(color, 0);
                }


                List<Tile> smallOne = factory.get(i);

                for (Tile tmp2 : smallOne) {
                    if (colors.contains(tmp2.getColor())) {
                        colorToNumber.put(tmp2.getColor(), colorToNumber.get(tmp2.getColor()) + 1);
                        colorToTile.put(tmp2.getColor(), tmp2);
                    }
                }

                for (String color : colorToNumber.keySet()) {
                    if (colorToNumber.get(color) == tileNumber) {
                        Tile tile = colorToTile.get(color);
                        tile.setBotUsedRow(tmp / 10);
                        tile.setBotUsedColumn(tmp % 10 - 1);
                        validTile.add(tile);
                    }

                }


            }

            Map<String, Integer> colorToNumber = new HashMap<>();
            Map<String, Tile> colorToTile = new HashMap<>();

            for (String color : colors) {
                colorToNumber.put(color, 0);
            }

            for (Tile tmp3 : Containers.Center.getGroup()) {
                if (colors.contains(tmp3.getColor())) {
                    colorToNumber.put(tmp3.getColor(), colorToNumber.get(tmp3.getColor()) + 1);
                    colorToTile.put(tmp3.getColor(), tmp3);
                }

            }

            for (String color : colorToNumber.keySet()) {
                if (colorToNumber.get(color) == tileNumber) {
                    Tile tile = colorToTile.get(color);
                    tile.setBotUsedRow(tmp / 10);
                    tile.setBotUsedColumn(tmp % 10 - 1);
                    validTile.add(tile);

                }

            }


        }

        for (int i = 0; i < tileNumbers.size(); i++) {
            if (tileNumbers.get(i) > 0) {
                break;
            }
            if (i == tileNumbers.size() - 1) {
                return;
            }

        }

        if (validTile.size() == 0) {
            pointer--;
            findTiles(pointer, validTile);

        }

    }

    /**
     * Find valid positions and corresponding colors
     * @return : A map to store position information and colors
     */
    private Map<Integer, String> selectPosition() {
        List<ArrayList<Tile>> storage = Actions.currentPlayer.storage.getGroup();
        List<ArrayList<Tile>> mosaic = Actions.currentPlayer.mosaic.getGroup();

        Map<Integer, String> table = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            List<String> colors = new ArrayList<>(Arrays.asList("blue", "#1d953f", "#fcaf17", "#694d9f", "#ed1941"));
            ArrayList<Tile> row = storage.get(i);

            int tileNumber = i + 1;
            StringBuilder color = new StringBuilder();

            if (row.size() != 0) {
                tileNumber = tileNumber - row.size();
                if (tileNumber == 0) {
                    continue;
                }

                colors.removeAll(colors);
                colors.add(row.get(0).getColor());
            }

            if (colors.size() == 5) {
                ArrayList<Tile> rowInMosaic = mosaic.get(i);

                for (Tile tile : rowInMosaic) {
                    if (tile != null) {
                        colors.remove(tile.getColor());
                    }
                }
            }

            int key = i * 10 + tileNumber;

            for (int j = 0; j < colors.size(); j++) {
                if (j == colors.size() - 1) {
                    color.append(colors.get(j));
                } else {
                    color.append(colors.get(j)).append(",");
                }
            }

            table.put(key, color.toString());

        }
        return table;


    }

    /**
     * Using animation to move tile to storage
     */
    public void moveTOStorage(Tile tile, double originalX, double originalY) {
        DragResult storageResult = Actions.DragAvailableInStorage(tile);

            /*
             If the moving place is valid
             */
        if (storageResult.getFlag()) {
            tile.setLayoutX(originalX);
            tile.setLayoutY(originalY);
            movingTile(storageResult.getCoordX(), storageResult.getCoordY(), tile, 0, false);

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
                        prepareNextRound(Locations.player, tile);
                        return;
                    }
                }
            }

            //If it is time to change player
            if (storageResult.isNextPlayer()) {
                GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(true);
                //Change player
                changePlayer(tile);

                return;
            }

            //If the placement is empty, change player
            if (Actions.currentPlayer.placement.getGroup().size() == 0) {
                GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(true);
                changePlayer(tile);
            }

            return;
        }


        //If the given coordinate is illegal,move the tile to original place
        tile.setLayoutX(tile.getOriginalX());
        tile.setLayoutY(tile.getOriginalY());


    }

    /**
     * Use animation to change player
     */
    private void changePlayer(Tile tile) {
        Timeline tl = new Timeline();

        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {
            GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);

            Actions.currentPlayer = Actions.currentPlayer.nextPlayer;

            //Change player board in GUI
            GUIActions.NextPlayer(GUIActions.currentGUIPlayer);
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
                Actions.penalty();
                //Update player's score
                GUIActions.currentGUIPlayer.getScore().setText(GUIActions.currentGUIPlayer.getGamePane().l1.getText() + " : " + Actions.currentPlayer.score);
                Actions.clearFloor();
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
     * If factory and center are all empty, move tiles to mosaic
     */
    public static void prepareNextRound(int pointer, Tile tile) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (Actions.currentPlayer.rightMost.get(i) != null) {
                indexes.add(Actions.currentPlayer.rightMost.get(i));
                Actions.currentPlayer.rightMost.set(i, null);
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            Tile tmp = Actions.currentPlayer.storage.getGroup().get(index).get(0);
            Actions.movingToMosaic(index);
            movingTile(tmp.getOriginalX(), tmp.getOriginalY(), tmp, i, i == indexes.size() - 1);

        }
        Timeline tl = new Timeline();
        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), actionEvent -> {
            if (pointer == 1) {
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

                if (Actions.currentPlayer == Player.Player2 && Actions.vsBot) {
                    Actions.bot.action();
                }


            } else {
                GUIActions.currentGUIPlayer.getGamePane().b2.setDisable(false);
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

    public void click(Tile tile) {
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



