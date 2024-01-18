## Code Review

Reviewed by: Xuanchen Wang u7323912

Reviewing code written by: Wangyi Li u7323052

Component: 


    public static DragResult DragAvailableInStorage(Tile tile) {
        // Get the coordinate of storage
        List<ArrayList<Double>> CoordX = Locations.getStorageCoordX();
        List<ArrayList<Double>> CoordY = Locations.getStorageCoordY();

        // The storage of current player
        Storage storage = currentPlayer.storage;

        //Get the properties from tile
        Double X = tile.getLayoutX();
        Double Y = tile.getLayoutY();
        String color = tile.getColor();

        // Indicate whether the input coordinate is a legal place to drag to
        boolean result = false;

        // The coordinate of corresponding legal place
        Double newX = null;
        Double newY = null;

        // The row of the legal place
        int row = 0;

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

                    //If the corresponding row in mosaic does not have the same color as the tile has
                    List<String> colors = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        colors.add(GUIActions.getMosaic(GUIActions.currentGUIPlayer.getSeed()).get(i * 5 + k).getColor());
                    }
                    if (!colors.contains(tile.getColor())) {
                        break outer;
                    }

                    result = true;
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
        return output;
    }

### Comments 

This method is to make a judgment that whether the place in storage when dragging a tile to is valid. If it is valid,put the tile into storage group in back-end and return a flag(boolean) to indicate if it can be moved in storage in GUI.
A highlight in this method is that it has a function that if the tile is in the range of the small gray rectangle, the tile will automatically put on the gray rectangle. This is a great fuction that bring convenience and beauty to the game. Besides these, she consides different kinds of occasions when dragging the tile. Like tiles in the same row must have the same color, you have to put the from left to right and you can not drage the tile from storage to storage. These occasions are highly to happen when playing the game, so it is convenient that these judgment wil hlep players to obey rules.This method is in great organization, codes are clear and easy to understsnd. This method denotes oo designing mind. In this method, returning parameters are multiple.So she creates a new class to store the returning result.


