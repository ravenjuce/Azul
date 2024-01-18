package comp1110.ass2.OurAzulGame.GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuanchen Wang
 * This is a enum to indicate different players, which is in order
 * to accurately do GUI operation for each player
 */
public enum GUIPlayer {
    Player1(new GamePane(1), 0, 1),
    Player2(new GamePane(2), 0, 2),
    Player3(new GamePane(3), 0, 3),
    Player4(new GamePane(4), 0, 4);


    private GamePane gamePane;
    private long seed;
    private List<Tile> mosaicBoard;
    private GUIPlayer nextPlayer;
    private Label score;
    private int playerNumber;

    GUIPlayer(GamePane gamePane, long seed, int playerNumber) {
        this.gamePane = gamePane;
        this.seed = seed;
        this.playerNumber = playerNumber;
        this.mosaicBoard = new ArrayList();
    }

    public GamePane getGamePane() {
        return gamePane;
    }

    public void setGamePane(GamePane gamePane) {
        this.gamePane = gamePane;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public List<Tile> getMosaicBoard() {
        return mosaicBoard;
    }

    public void setMosaicBoard(List<Tile> mosaicBoard) {
        this.mosaicBoard = mosaicBoard;
    }

    public GUIPlayer getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(GUIPlayer nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Label getScore() {
        if (score == null) score = new Label(gamePane.l1.getText() + " : 0");
        score.setStyle("-fx-font-size: 15");
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
