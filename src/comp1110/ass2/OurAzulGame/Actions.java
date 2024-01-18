package comp1110.ass2.OurAzulGame;

import comp1110.ass2.OurAzulGame.GUI.*;

import java.util.*;

/**
 * @Author: Xuanchen Wang, Wangyi Li, Zixin Feng
 * This is a class including all the back-end methods
 */
public class Actions {
    //Indicate the current player
    public static Player currentPlayer;

    public static Player firstPlayer;

    public static boolean selfConfigureModel = false;
    public static int selfConfigureModelArg = 0;

    public static final Bot bot = new Bot();

    public static boolean vsBot = false;


    /**
     * @Author: Zixin Feng
     * This is a method to fill the factory group in the back-end
     */
    public static void FillFactory() {
        //A list to restore selected tiles
        ArrayList<Tile> selected = new ArrayList<>();

        Random random = new Random();
        List<Integer> ran = new ArrayList<>();

        //Get the group of bag and discard
        List<Tile> bag = Containers.Bag.getGroup();
        List<Tile> discard = Containers.Discard.getGroup();

        //If there is not enough tiles in bag
        if (bag.size() < Locations.getFactoryCoordX().size() * 4) {
            //Add tiles in discard to bag
            bag.addAll(discard);
            discard.removeAll(discard);

        }


        //The number of tiles that should be put in factory
        int tileNumber = Locations.getFactoryCoordX().size() * 4;

        //If there are not enough tiles in bag, add all tiles in bag to factory
        if (bag.size() < Locations.getFactoryCoordX().size() * 4) {
            tileNumber = bag.size();
        }

        //  Generate non-respective numbers
        while (ran.size() < tileNumber) {
            int i = random.nextInt(bag.size());
            if (!ran.contains(i)) {
                ran.add(i);
            }
        }

        /*
         * Get the tile from the bag and set its property
         * */


        for (int i = 0; i < Locations.getFactoryCoordX().size(); i++) {
            int a = i * 4;

            for (int j = 0; j < 4; j++) {
                //Get tile from the bag
                Tile tmp = Containers.Bag.getGroup().get((ran.get(a + j)));


                Factory.getGroup().get(i).add(tmp);

                tmp.setGroup(Factory.getGroup().get(i));
                tmp.setGroupName(Factory.getGroupName().get(i));

                selected.add(tmp);

            }
        }

        //Remove the selected tile from the bag
        Containers.Bag.getGroup().removeAll(selected);


    }


    /**
     * @Author: Xuanchen Wang
     * Whether the place in storage that the tile is dragged to is legal(not completely finished)
     */
    public static DragResult DragAvailableInStorage(Tile tile) {
        // Get the coordinate of storage
        List<ArrayList<Double>> CoordX = Locations.getStorageCoordX();
        List<ArrayList<Double>> CoordY = Locations.getStorageCoordY();

        // The storage of current player
        Storage storage = currentPlayer.storage;

        //Get the properties from tile
        double X = tile.getLayoutX();
        double Y = tile.getLayoutY();
        String color = tile.getColor();

        // Indicate whether the input coordinate is a legal place to drag to
        boolean result = false;

        //Indicate whether it is time to change player
        boolean nextPlayer = false;

        // The coordinate of corresponding legal place
        Double newX = null;
        Double newY = null;

        // The row of the legal place
        int row = 0;

        //The corresponding position in mosaic for the tile
        int column = 0;

        // Output result including elements need to be returned
        DragResult output = new DragResult();

        /*
         Iterate the whole storage area and find out whether the coordinate is legal
         */
        outer:
        for (int i = 0; i < CoordX.size(); i++) {
            // The index of the row
            row = i;

            // The number of tiles which already exist in the row
            int otherTiles = storage.getGroup().get(i).size();

            // Iterate places in each row
            for (int j = 0; j < i + 1; j++) {
                // If the coordinate is legal
                if ((CoordX.get(i).get(j) - 20 < X && X < CoordX.get(i).get(j) + 20) && (CoordY.get(i).get(0) - 20 < Y && Y < CoordY.get(i).get(0) + 20)) {

                    // The tile must be placed from right to left without gap
                    if (j != i - otherTiles) {
                        break outer;
                    }

                    // All the tiles in the same row must have the same color
                    if (otherTiles > 0 && !storage.getGroup().get(i).get(0).getColor().equals(color)) {
                        break outer;
                    }

                    //If the tile is dragged from storage or mosaic
                    if (tile.getGroupName().equals("Storage") || tile.getGroupName().equals("Mosaic")) {
                        break outer;
                    }

                    //If the corresponding row in mosaic already has a tile with the same color
                    for (int k = 0; k < 5; k++) {
                        if (GUIActions.currentGUIPlayer.getMosaicBoard().get(5 * i + k).getColor().equals(tile.getColor())
                                && Actions.currentPlayer.mosaic.getGroup().get(i).get(k) != null) {
                            break outer;
                        }
                    }

                    result = true;

                    /*
                     If the row in storage is full after dragging this tile to its place.
                     If there are remaining tiles in the placement, move them to floor
                     */
                    if (storage.getGroup().get(i).size() == i) {
                        Placement placement = currentPlayer.placement;

                        //If there are tiles in placement, move them to floor
                        if (placement.getGroup().size() != 0) {
                            for (Tile tmp : placement.getGroup()) {
                                Actions.currentPlayer.floor.getGroup().add(tmp);
                                tmp.setGroup(Actions.currentPlayer.floor.getGroup());
                                tmp.setGroupName(Actions.currentPlayer.floor.getGroupName());
                            }
                            placement.getGroup().removeAll(placement.getGroup());
                        }

                        currentPlayer.rightMost.set(i, i);

                        //Change player
                        nextPlayer = true;

                    }



                    /*
                     If the one tile is in placement, move it to floor
                     */
                    if (currentPlayer.placement.getGroup().contains(GUICenter.getOne())) {
                        Tile one = GUICenter.getOne();
                        currentPlayer.floor.getGroup().add(one);
                        one.getGroup().remove(one);
                        one.setGroup(currentPlayer.floor.getGroup());
                        one.setGroupName(currentPlayer.floor.getGroupName());

                        firstPlayer = currentPlayer;
                    }

                    newX = CoordX.get(i).get(j);
                    newY = CoordY.get(i).get(0);

                    //Add the tile to the group
                    storage.getGroup().get(i).add(tile);

                    //Remove the tile from its original group
                    tile.getGroup().remove(tile);

                    tile.setGroup(storage.getGroup().get(i));
                    tile.setGroupName(storage.getGroupName());

                    break outer;
                }
            }
        }


        output.setFlag(result);
        output.setCoordX(newX);
        output.setCoordY(newY);
        output.setRow(row);
        output.setNextPlayer(nextPlayer);
        output.setColumnInMosaic(column);
        return output;
    }

    /**
     * @Author: Wangyi Li (revised by Xuanchen Wang)
     * Whether the place in mosaic that the tile is dragged to is legal
     */
    public static DragResult DragAvailableInMosaic(Tile tile) {
        //Get the coordinate of storage
        List<ArrayList<Double>> CoordX = Locations.getMosaicCoordX();
        List<ArrayList<Double>> CoordY = Locations.getMosaicCoordY();

        Mosaic mosaic = currentPlayer.mosaic;

        double X = tile.getLayoutX();
        double Y = tile.getLayoutY();

        Double newX = null;
        Double newY = null;
        boolean result = false;
        Integer row = null;
        Integer column = null;
        DragResult output = new DragResult();

        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((CoordX.get(0).get(j) - 20 < X && X < CoordX.get(0).get(j) + 20) && (CoordY.get(i).get(0) - 20 < Y && Y < CoordY.get(i).get(0) + 20)) {


                    //If the row of the storage is not full
                    if (tile.getGroup().size() != i + 1) break outer;

                    //If the column has the same color as the tile has
                    for (int k = 0; k < 5; k++) {
                        Tile tmp = mosaic.getGroup().get(k).get(j);
                        if (!(tmp == null) && tmp.getColor().equals(tile.getColor()) && k != i) {
                            break outer;
                        }
                    }

                    //If the row already has the tile with the same color
                    ArrayList<Tile> tmp = mosaic.getGroup().get(i);
                    for (Tile tmp1 : tmp) {
                        if (tmp1 != null && tmp1.getColor().equals(tile.getColor())) {
                            break outer;
                        }
                    }


                    result = true;
                    newX = CoordX.get(0).get(j);
                    newY = CoordY.get(i).get(0);
                    row = i;
                    column = j;

                    mosaic.getGroup().get(i).set(j, tile);

                    tile.getGroup().remove(tile);

                    tile.setGroup(mosaic.getGroup().get(i));
                    tile.setGroupName(mosaic.getGroupName());

                    //Move remaining tiles in the same row in storage
                    List<Tile> rowInStorage = currentPlayer.storage.getGroup().get(i);
                    Containers.Discard.getGroup().addAll(rowInStorage);
                    rowInStorage.removeAll(rowInStorage);


                    break outer;
                }
            }
        }

        output.setFlag(result);
        output.setCoordX(newX);
        output.setCoordY(newY);
        output.setRow(row);
        output.setColumnInMosaic(column);
        return output;
    }

    /**
     * @Author: Xuanchen Wang
     * Click tile in center
     */
    public static void clickInCenter(Tile tile) {
        //A list to store the tile should be placed in placement
        Placement placement = currentPlayer.placement;

        //The center group
        Containers center = Containers.Center;

        Tile one = GUICenter.getOne();

        //If the first player tile is in the center, put it to placement
        if (center.getGroup().get(0) == one) {
            placement.getGroup().add(one);
            center.getGroup().remove(0);

            one.setGroup(placement.getGroup());
            one.setGroupName(placement.getGroupName());

            firstPlayer = currentPlayer;


        }

        //Iterate tiles in center
        for (Tile tmp : center.getGroup()) {
            //If the other tile in center has the same color, put it to placement
            if (tile.getColor().equals(tmp.getColor())) {
                placement.getGroup().add(tmp);
                tmp.setGroup(placement.getGroup());
                tmp.setGroupName(placement.getGroupName());


            }
        }
        center.getGroup().removeAll(placement.getGroup());
    }


    /**
     * @Author: Xuanchen Wang
     * click tile in factory
     */
    public static void clickInFactory(Tile tile) {
        //Two lists to store the tile where it belongs to
        Placement placement = currentPlayer.placement;
        Containers center = Containers.Center;

        List<Tile> oldGroup = tile.getGroup();

        //Iterate all the tiles in the same group
        for (Tile tmp : oldGroup) {
            //If the tile in the group has the same color, it should be placed in placement
            if (tmp.getColor().equals(tile.getColor())) {
                placement.getGroup().add(tmp);
                tmp.setGroup(placement.getGroup());
                tmp.setGroupName(placement.getGroupName());

            } else {
                center.getGroup().add(tmp);
                tmp.setGroup(center.getGroup());
                tmp.setGroupName(center.getGroupName());
            }
        }


        oldGroup.removeAll(oldGroup);

    }

    /**
     * Link all the players together after player number is decided
     * @Author: Xuanchen Wang
     * @param playerNumber
     */
    static public void link(int playerNumber) {
        switch (playerNumber) {
            case 2 -> {
                Player.Player1.nextPlayer = Player.Player2;
                Player.Player2.nextPlayer = Player.Player1;
            }
            case 3 -> {
                Player.Player1.nextPlayer = Player.Player2;
                Player.Player2.nextPlayer = Player.Player3;
                Player.Player3.nextPlayer = Player.Player1;
            }
            case 4 -> {
                Player.Player1.nextPlayer = Player.Player2;
                Player.Player2.nextPlayer = Player.Player3;
                Player.Player3.nextPlayer = Player.Player4;
                Player.Player4.nextPlayer = Player.Player1;
            }
        }
    }

    /**
     * Move the rightmost tile in a row to mosaic
     * @Author: Xuanchen Wang
     * @param row
     */
    public static void movingToMosaic(int row) {

        Tile tile = currentPlayer.storage.getGroup().get(row).get(0);

        Storage storage = currentPlayer.storage;

        //Find the corresponding place for tile in mosaic
        for (int k = 0; k < 5; k++) {
            if (GUIActions.currentGUIPlayer.getMosaicBoard().get(5 * row + k).getColor().equals(tile.getColor())) {
                Mosaic mosaic = Actions.currentPlayer.mosaic;

                //Move the tile to mosaic
                mosaic.getGroup().get(row).set(k, tile);

                tile.getGroup().remove(tile);

                tile.setGroup(mosaic.getGroup().get(row));
                tile.setGroupName(mosaic.getGroupName());

                tile.setOriginalX(Locations.getMosaicCoordX().get(0).get(k));
                tile.setOriginalY(Locations.getMosaicCoordY().get(row).get(0));

                //Move the other tiles in the same row to discard
                for (Tile tmp : storage.getGroup().get(row)) {
                    Containers.Discard.getGroup().add(tmp);
                    tmp.setGroup(Containers.Discard.getGroup());
                    tmp.setGroupName(Containers.Discard.GroupName);
                }

                //Clear all the elements in the row
                storage.getGroup().get(row).removeAll(storage.getGroup().get(row));

                //Calculate points and update player's score
                currentPlayer.score += calculatePoints(row, k);

                break;
            }
        }

    }

    /**
     * Calculate points after moving tile to mosaic
     * @param row : the row number of the tile
     * @param column : the column number of the tile
     * @return : points
     * @Author: Xuanchen Wang
     */
    public static int calculatePoints(int row, int column) {
        int score = 0;

        //Whether the tile is alone in row and column
        boolean aloneInRow = false;
        boolean aloneInColumn = false;

        List<ArrayList<Tile>> mosaicGroup = currentPlayer.mosaic.getGroup();

        //To store the value of score in this time
        int oldValue1 = score;

        /*
         Search in the column
         */
        for (int i = 1; row - i >= 0; i++) {
            if (mosaicGroup.get(row - i).get(column) == null) break;
            score++;
        }

        for (int i = 1; row + i < 5; i++) {
            if (mosaicGroup.get(row + i).get(column) == null) break;
            score++;
        }

        //If the tile is adjacent to other tile, add one point(count itself)
        if (oldValue1 != score) {
            score++;
        } else aloneInColumn = true;

        //Store the value of score after searching in the column
        int oldValue2 = score;

        /*
         Search in the row
         */
        for (int i = 1; column - i >= 0; i++) {
            if (mosaicGroup.get(row).get(column - i) == null) break;
            score++;
        }

        for (int i = 1; column + i < 5; i++) {
            if (mosaicGroup.get(row).get(column + i) == null) break;
            score++;
        }

        if (oldValue2 != score) {
            score++;
        } else aloneInRow = true;

        //If the tile is not adjacent to any other tile both in column and row, add one point
        if (aloneInRow && aloneInColumn) score++;


        return score;
    }

    /**
     * Minus points according to the tile number in floor
     * @Author: Xuanchen Wang
     */
    public static void penalty() {
        int penalty = currentPlayer.floor.getGroup().size();

        switch (penalty) {
            case 0 -> {
            }
            case 1 -> currentPlayer.score -= 1;
            case 2 -> currentPlayer.score -= 2;
            case 3 -> currentPlayer.score -= 4;
            case 4 -> currentPlayer.score -= 6;
            case 5 -> currentPlayer.score -= 8;
            case 6 -> currentPlayer.score -= 11;
            default -> currentPlayer.score -= 14;
        }

        if (currentPlayer.score < 0) currentPlayer.score = 0;

    }

    /**
     * Move tiles in floor to discard
     * @Author: Xuanchen Wang
     */
    public static void clearFloor() {
        List<Tile> floor = currentPlayer.floor.getGroup();

        for (Tile tmp : floor) {
            if (tmp == GUICenter.getOne()) {
                Containers.Center.getGroup().add(tmp);

                tmp.setGroup(Containers.Center.getGroup());
                tmp.setGroupName(Containers.Center.getGroupName());
            } else {
                Containers.Discard.getGroup().add(tmp);

                tmp.setGroup(Containers.Discard.getGroup());
                tmp.setGroupName(Containers.Discard.getGroupName());
            }

        }
        floor.removeAll(floor);
    }

    /**
     * Move tiles in placement to floor
     * @Author: Xuanchen Wang
     */
    public static void clearPlacement() {
        List<Tile> placement = currentPlayer.placement.getGroup();

        for (Tile tmp : placement) {
            currentPlayer.floor.getGroup().add(tmp);
            tmp.setGroup(currentPlayer.floor.getGroup());
            tmp.setGroupName(currentPlayer.floor.getGroupName());

        }

        placement.removeAll(placement);
    }

    /**
     * Calculate bonus points when the game is over
     * @Author: Xuanchen Wang
     */
    public static void calculateBonusPoints() {
        for (int playerNumber = 0; playerNumber < Locations.player; playerNumber++) {
            List<ArrayList<Tile>> mosaic = currentPlayer.mosaic.getGroup();

            /*
             *Calculate bonus points for completing each row
             */
            for (int i = 0; i < 5; i++) {
                boolean completeRow = true;
                for (int j = 0; j < 5; j++) {
                    if (mosaic.get(i).get(j) == null) {
                        completeRow = false;
                        break;
                    }

                }
                if (completeRow) {
                    currentPlayer.score += 2;
                    currentPlayer.completeRow++;
                }

            }

            /*
             *Calculate points for completing each column
             */
            for (int i = 0; i < 5; i++) {
                boolean completeRow = true;
                for (int j = 0; j < 5; j++) {
                    if (mosaic.get(j).get(i) == null) {
                        completeRow = false;
                        break;
                    }
                }
                if (completeRow) currentPlayer.score += 7;
            }

            /*
             *Calculate points for five tiles with the same color
             */

            //A map to store the number of tiles in different color
            Map<String, Integer> tileNumber = new HashMap<>();

            String[] colors = {"blue", "#1d953f", "#fcaf17", "#694d9f", "#ed1941"};

            //Initialize colors
            for (String color : colors) {
                tileNumber.put(color, 0);
            }

            //Get the number of tiles in each color
            for (int i = 0; i < 5; i++) {
                for (Tile tile : mosaic.get(i)) {
                    if (tile != null) {
                        String color = tile.getColor();
                        tileNumber.put(color, tileNumber.get(color) + 1);
                    }
                }
            }

            for (Integer integer : tileNumber.values()) {
                if (integer == 5) {
                    currentPlayer.score += 10;
                }
            }

            currentPlayer = currentPlayer.nextPlayer;


        }

    }

    /**
     * Indicate whether the game is over
     * @return : If the game is over
     * @Author: Xuanchen Wang
     */
    public static boolean isEndOfGame() {
        boolean isEndOfGame = false;
        outer:
        for (int playerNumber = 0; playerNumber < Locations.player; playerNumber++) {
            List<ArrayList<Tile>> mosaic = currentPlayer.mosaic.getGroup();

            /*
             *Find whether any of the row is completed
             */
            for (int i = 0; i < 5; i++) {
                boolean completeRow = true;
                for (Tile tile : mosaic.get(i)) {
                    if (tile == null) {
                        completeRow = false;
                        break;
                    }
                }
                if (completeRow) {
                    isEndOfGame = true;
                    break outer;
                }
            }

            //Change player
            currentPlayer = currentPlayer.nextPlayer;
        }
        return isEndOfGame;
    }

    /**
     * When the game is over, find winner
     * @return Winner name
     * @Author: Xuanchen Wang
     */
    public static String findWinner() {
        int maxScore = 0;

        //A list to store winner players
        List<Player> winner = new ArrayList<>();

        for (int playerNumber = 0; playerNumber < Locations.player; playerNumber++) {
            if (currentPlayer.score > maxScore) {
                maxScore = currentPlayer.score;

                winner.removeAll(winner);
                winner.add(currentPlayer);
            } else if (currentPlayer.score == maxScore) {
                winner.add(currentPlayer);
            }

            currentPlayer = currentPlayer.nextPlayer;


        }

        /*
         *If there are multiple winners, further comparison
         */
        if (winner.size() != 1) {
            List<Player> tmp = new ArrayList<>();
            int maxCompleteRow = 0;

            for (Player player : winner) {

                if (player.completeRow > maxCompleteRow) {
                    maxCompleteRow = player.completeRow;
                    tmp.removeAll(tmp);
                    tmp.add(player);

                } else if (player.completeRow == maxCompleteRow) {
                    tmp.add(player);
                }
            }

            winner.removeAll(winner);
            winner.addAll(tmp);

        }

        StringBuilder output = new StringBuilder("Congratulation! ");

        //Get winners
        for (Player player : winner) {
            output.append(player.name + " ");
        }

        //Be careful about the grammar
        if (winner.size() == 1) {
            output.append("wins");
        } else {
            output.append("win");
        }

        return output.toString();

    }

    /**
     * When the game is over, restart the game
     * @Author: Xuanchen Wang
     */
    public static void restart() {
        //Reset all the container groups
        Containers.Discard.setGroup(new ArrayList<>());
        Containers.Bag.setGroup(new ArrayList<>());
        Containers.Center.setGroup(new ArrayList<>());

        for (int player = 0; player < Locations.player; player++) {
            //Reset all the properties for each player
            currentPlayer.completeRow = 0;
            currentPlayer.score = 0;
            currentPlayer.mosaic = new Mosaic();
            currentPlayer.storage = new Storage();
            currentPlayer.rightMost = new ArrayList<>();
            currentPlayer.floor = new Floor();
            currentPlayer.placement = new Placement();

            //Change player
            currentPlayer = currentPlayer.nextPlayer;

        }

    }
}




