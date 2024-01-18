## Code Review

Reviewed by: <zixin feng>, <U7233947>

Reviewing code written by: <Xuanchen Wang> <u7323912>

Component:
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


        }

        //Iterate tiles in center
        for (Tile tmp : center.getGroup()) {
            //If the other tile in center has the same color, put it to placement
            if (tile.getColor().equals(tmp.getColor())) {
                placement.getGroup().add(tmp);

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
        for (int i = 0; i < oldGroup.size(); i++) {
            //Get the tile from the group

            Tile tmp = oldGroup.get(i);

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

}
### Comments

<write your comments here>
This method is to realize two actions click tile in factory and click tile in center. He set placement to store tile and GUI center. If the first player tile is in the center, it will be put to placement. And he iterate tiles in center with clear document. That is great and helpful.
if the colors of tile is same, they will be place together. At the end, remove all. The process of Click in factory is almost same as above. iterate all tile in a same group. And then If the tile in the group has the same color, it will be placed in placement. Else it will be placed in center. At the end remove all.
There is no obvious errors and decomposition is used appropriately. Well done.